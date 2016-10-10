package com.taotao.common.pojo;
/**
 *  上传图片参数Po
 * @ClassName: PictureResult 
 * @author: szy
 * @date: 2016年10月10日 上午10:12:03
 */
public class PictureResult {
	private int error;
	private String url;
	private String message;

	public int getError() {
		return error;
	}

	public void setError(int error) {
		this.error = error;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
