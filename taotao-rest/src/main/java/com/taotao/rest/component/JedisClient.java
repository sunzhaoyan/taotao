package com.taotao.rest.component;

/**
 * Jedis接口 用于切换单机版和集群版redis
 * 
 * @ClassName: JedisClient
 * @Description: TODO
 * @author: szy
 * @date: 2016年10月15日 下午10:22:12
 */
public interface JedisClient {
	/**
	 * 赋值
	 * @Title: set 
	 * @Description: TODO
	 * @param key
	 * @param value
	 * @return
	 * @return: String
	 */
	public String set(String key, String value);
	
	/**
	 * 获得值
	 * @Title: get 
	 * @Description: TODO
	 * @param key
	 * @return
	 * @return: String
	 */
	public String get(String key);

	/**
	 * 赋hash值
	 * @Title: hset 
	 * @Description: TODO
	 * @param key
	 * @param item
	 * @param value
	 * @return
	 * @return: Long
	 */
	public Long hset(String key, String item, String value);

	/**
	 * 获得hash值
	 * @Title: hget 
	 * @Description: TODO
	 * @param key
	 * @param item
	 * @return
	 * @return: String
	 */
	public String hget(String key, String item);
	
	/**
	 * 值加1
	 * @Title: incr 
	 * @Description: TODO
	 * @param key
	 * @return
	 * @return: Long
	 */
	public Long incr(String key);

	/**
	 * 值减1
	 * @Title: decr 
	 * @Description: TODO
	 * @param key
	 * @return
	 * @return: Long
	 */
	public Long decr(String key);

	/**
	 * 设置过期时间，单位秒
	 * @Title: expire 
	 * @Description: TODO
	 * @param key
	 * @param seconds
	 * @return
	 * @return: Long
	 */
	public Long expire(String key, int seconds);

	/**
	 * 获得过期时间，单位秒 ，>0 正在倒计时，=0?， -1永久，-2过期
	 * @Title: ttl 
	 * @Description: TODO
	 * @param key
	 * @return
	 * @return: Long
	 */
	public Long ttl(String key);
	
	/**
	 * 删除key
	 * @Title: del 
	 * @Description: TODO
	 * @param key
	 * @return
	 * @return: Long
	 */
	public Long del(String key);
	
	/**
	 * hash删除key
	 * @Title: hdel 
	 * @Description: TODO
	 * @param key
	 * @param item
	 * @return
	 * @return: Long
	 */
	public Long hdel(String key, String item);
}
