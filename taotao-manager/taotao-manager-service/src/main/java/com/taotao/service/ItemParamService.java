package com.taotao.service;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;

/**
 * 商品规格参数模板
 * @author szy
 *
 */
public interface ItemParamService {
	/**
	 * 分页获得商品规格参数模板
	 * @param page
	 * @param rows
	 * @return
	 */
	public EasyUIDataGridResult getItemList(int page, int rows);
	
	/**
	 * 根据商品分类 查询规格参数模板
	 * @param cid
	 * @return
	 */
	public TaotaoResult getItemParamByCid(Long cid);
	
	/**
	 * 新增商品规格参数模板 
	 * @Title: insertItemParam 
	 * @param id
	 * @param itemParam
	 * @return
	 * @return: TaotaoResult
	 */
	public TaotaoResult insertItemParam(Long cid, String paramData);
}
