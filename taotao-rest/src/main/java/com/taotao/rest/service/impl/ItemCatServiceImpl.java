package com.taotao.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.util.JSONUtils;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.pojo.TbItemCatExample.Criteria;
import com.taotao.rest.component.JedisClient;
import com.taotao.rest.pojo.CatNode;
import com.taotao.rest.pojo.ItemCatResult;
import com.taotao.rest.service.ItemCatService;

@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private TbItemCatMapper itemCatMapper;
	@Autowired
	private JedisClient jedisClient;
	@Value("${REDIS_ITEM_CAT_KEY}")
	private String REDIS_ITEM_CAT_KEY;

	@Override
	public ItemCatResult getItemCatList() {
		try {
			String json = jedisClient.hget(REDIS_ITEM_CAT_KEY, 0l + "");
			if (!StringUtils.isBlank(json)) {
				List<Object> list = JSONUtils.json2list(json, Object.class);
				ItemCatResult result = new ItemCatResult();
				result.setData(list);
				return result;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 调用递归方法查询商品分类列表
		List<?> catList = getItemCatList(0l);
		// 返回结果
		ItemCatResult result = new ItemCatResult();
		result.setData(catList);
		try {
			jedisClient.hset(REDIS_ITEM_CAT_KEY, 0l + "", JSONUtils.obj2json(catList));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	private List<Object> getItemCatList(Long parentId) {
		// 根据parentId查询列表
		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		// 执行查询
		List<TbItemCat> list = itemCatMapper.selectByExample(example);
		List<Object> resultList = new ArrayList<Object>();
		int count = 0;
		for (TbItemCat tbItemCat : list) {
			if (count >= 14) {
				break;
			}
			// 如果是父节点
			if (tbItemCat.getIsParent()) {
				CatNode node = new CatNode();
				node.setUrl("/products/" + tbItemCat.getId() + ".html");
				// 如果当前节点为第一级节点
				if (tbItemCat.getParentId() == 0) {
					node.setName("<a href='/products/" + tbItemCat.getId() + ".html'>" + tbItemCat.getName() + "</a>");
					count++;
				} else {
					node.setName(tbItemCat.getName());
				}
				node.setItems(getItemCatList(tbItemCat.getId()));
				// 把node添加到列表
				resultList.add(node);
			} else {
				// 如果是叶子节点
				String item = "/products/" + tbItemCat.getId() + ".html|" + tbItemCat.getName();
				resultList.add(item);
			}
		}
		return resultList;
	}

	@Override
	public TaotaoResult syncItemCat(Long parentId) {
		jedisClient.hdel(REDIS_ITEM_CAT_KEY, parentId + "");
		return TaotaoResult.ok();
	}

}