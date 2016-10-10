package com.taotao.common.pojo;

import java.util.List;
/**
 * easyUI 表格数据返回格式
 * @ClassName: EasyUIDataGridResult 
 * @author: szy
 * @date: 2016年10月10日 上午10:11:04
 */
public class EasyUIDataGridResult {
	private long total;
	private List<?> rows;

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

}
