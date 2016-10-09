package com.taotao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.service.ItemCatService;

@Controller
@RequestMapping("/item/cat")
public class ItemCatController {

	@Autowired
	ItemCatService itemCatService;

	@RequestMapping("/list")
	@ResponseBody
	public List<EasyUITreeNode> getItemCatList(
			@RequestParam(value = "id", required = true, defaultValue = "0") Long parentId) {
		List<EasyUITreeNode> itemCatList = itemCatService.getItemCatList(parentId);
		return itemCatList;
	}
}
