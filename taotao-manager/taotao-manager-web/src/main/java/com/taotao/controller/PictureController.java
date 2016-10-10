package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.taotao.common.pojo.PictureResult;
import com.taotao.common.util.JSONUtils;
import com.taotao.service.PictureService;

/**
 * 图片Controller
 * 
 * @ClassName: PictureController
 * @author: szy
 * @date: 2016年10月10日 上午10:22:42
 */
@Controller
public class PictureController {
	@Autowired
	private PictureService pictureService;
	
	/**
	 * 上传图片
	 * @Title: uploadFile 
	 * @param uploadFile
	 * @return
	 * @return: PictureResult
	 */
	@RequestMapping("/pic/upload")
	@ResponseBody
	public String uploadFile(MultipartFile uploadFile) {
		PictureResult result = pictureService.uploadPic(uploadFile);
		String json = null;
		try {
			json = JSONUtils.obj2json(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}

}
