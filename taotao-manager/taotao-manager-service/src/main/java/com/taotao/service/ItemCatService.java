package com.taotao.service;

import java.util.List;

import com.taotao.common.pojo.EasyUITreeNode;
/**
 * 商品类目
 * @author szy
 *
 */
public interface ItemCatService {
	List<EasyUITreeNode> getItemCatList(long parentId);
}
