package com.taotao.rest.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.util.JSONUtils;
import com.taotao.mapper.TbContentMapper;
import com.taotao.pojo.TbContent;
import com.taotao.pojo.TbContentExample;
import com.taotao.pojo.TbContentExample.Criteria;
import com.taotao.rest.component.JedisClient;
import com.taotao.rest.service.ContentService;

@Service
public class ContentServiceImpl implements ContentService {
	@Autowired
	private TbContentMapper contentMapper;
	/** jedis客户端 */
	@Autowired
	private JedisClient jedisClient;

	@Value("${REDIS_CONTENT_KEY}")
	private String REDIS_CONTENT_KEY;

	/**
	 * 根据分类id返回内容列表
	 */
	@Override
	public List<TbContent> getContentList(Long cid) {
		// 添加到缓存
		// 查询有无缓存，有缓存直接返回，不查询数据库
		try {
			String json = jedisClient.hget(REDIS_CONTENT_KEY, cid + "");
			if (!StringUtils.isBlank(json)) {
				List<TbContent> list = JSONUtils.json2list(json, TbContent.class);
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 注意：redis不影响正常逻辑，缓存出错或者没有，从数据库查询
		TbContentExample example = new TbContentExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(cid);
		List<TbContent> list = contentMapper.selectByExampleWithBLOBs(example);

		// 返回查询前，添加缓存
		try {
			jedisClient.hset(REDIS_CONTENT_KEY, cid + "", JSONUtils.obj2json(list));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public TaotaoResult syncContent(Long cid) {
		jedisClient.hdel(REDIS_CONTENT_KEY, cid + "");
		return TaotaoResult.ok();
	}

}
