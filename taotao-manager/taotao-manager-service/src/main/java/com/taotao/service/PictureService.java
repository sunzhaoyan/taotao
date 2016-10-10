package com.taotao.service;

import org.springframework.web.multipart.MultipartFile;

import com.taotao.common.pojo.PictureResult;

/**
 * 图片service
 * @ClassName: PictureService 
 * @author: szy
 * @date: 2016年10月10日 上午10:16:40
 */
public interface PictureService {
	/**
	 * 上传图片方法
	 * @Title: uploadPic 
	 * @param picFile
	 * @return
	 * @return: PictureResult
	 */
	public PictureResult uploadPic(MultipartFile picFile);
}
