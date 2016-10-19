package com.taotao.portal.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.portal.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Override
	public TaotaoResult addCert(Long itemId, Integer num, HttpServletRequest request, HttpServletResponse response) {
		return null;
	}

}
