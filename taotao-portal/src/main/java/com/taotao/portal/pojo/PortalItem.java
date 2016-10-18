package com.taotao.portal.pojo;

import com.taotao.pojo.TbItem;

public class PortalItem extends TbItem {
	public String[] getImages() {
		String images = this.getImage() ;
		if (images != null && !"".equals(images)) {
			return images.split(",");
		}
		return null;
	}
}
