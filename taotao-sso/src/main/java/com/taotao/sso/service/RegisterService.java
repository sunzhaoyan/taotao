package com.taotao.sso.service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbUser;

/**
 * 用户注册接口
 * 
 * @ClassName: RegisterService
 * @Description: TODO
 * @author: szy
 * @date: 2016年10月19日 下午1:58:01
 */
public interface RegisterService {

	/**
	 * 检查数据
	 * 
	 * @Title: checkData
	 * @Description: TODO
	 * @param param
	 * @param type
	 *            1 username, 2 phone, 3 email
	 * @return
	 * @throws Exception
	 * @return: TaotaoResult
	 */
	public TaotaoResult checkData(String param, Integer type) throws Exception;

	/**
	 * 用户注册方法
	 * 
	 * @Title: register
	 * @Description: TODO
	 * @param user
	 * @return
	 * @throws Exception
	 * @return: TaotaoResult
	 */
	public TaotaoResult register(TbUser user) throws Exception;
}
