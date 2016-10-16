package com.taotao.search.mapper;

import java.util.List;

import com.taotao.search.pojo.SearchItem;

/**
 * 搜索商品接口
 * @ClassName: ItemMapper 
 * @Description: TODO
 * @author: szy
 * @date: 2016年10月16日 下午4:27:59
 */
public interface ItemMapper {
	/**
	 * 获得搜索商品结果列表
	 * @Title: getItemList 
	 * @Description: TODO
	 * @return
	 * @return: List<SearchItem>
	 */
	public List<SearchItem> getItemList();
}
