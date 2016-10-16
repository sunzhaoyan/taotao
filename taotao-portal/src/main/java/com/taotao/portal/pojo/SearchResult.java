package com.taotao.portal.pojo;

import java.util.List;

/**
 * 搜索返回结果对象
 * 
 * @ClassName: SearchResult
 * @Description: TODO
 * @author: szy
 * @date: 2016年10月16日 下午9:26:39
 */
public class SearchResult {
	private List<SearchItem> itemList;
	private Long recordCount;
	private int pageCount;
	private int curPage;

	public List<SearchItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<SearchItem> itemList) {
		this.itemList = itemList;
	}

	public Long getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(Long recordCount) {
		this.recordCount = recordCount;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

}
