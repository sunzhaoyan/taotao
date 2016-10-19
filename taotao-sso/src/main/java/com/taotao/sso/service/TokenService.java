package com.taotao.sso.service;

import com.taotao.common.pojo.TaotaoResult;

/**
 * 获得用户session及过期时间
 * @ClassName: TokenService 
 * @Description: TODO
 * @author: szy
 * @date: 2016年10月19日 下午2:40:59
 */
public interface TokenService {
	/**
	 * 
	 * @Title: getUserByToken 
	 * @Description: TODO
	 * @param token
	 * @return
	 * @return: TaotaoResult
	 */
	public TaotaoResult getUserByToken(String token);
}
