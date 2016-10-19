package com.taotao.sso.component.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.taotao.sso.component.JedisClient;

import redis.clients.jedis.JedisCluster;

/**
 * jedis集群版实现类
 * 
 * @ClassName: JedisClientCluster
 * @Description: TODO
 * @author: szy
 * @date: 2016年10月15日 下午10:47:36
 */
public class JedisClientCluster implements JedisClient {

	@Autowired
	private JedisCluster jedisCluster;

	@Override
	public String set(String key, String value) {
		String result = jedisCluster.set(key, value);
		return result;
	}

	@Override
	public String get(String key) {
		String result = jedisCluster.get(key);
		return result;
	}

	@Override
	public Long hset(String key, String item, String value) {
		Long result = jedisCluster.hset(key, item, value);
		return result;
	}

	@Override
	public String hget(String key, String item) {
		String result = jedisCluster.hget(key, item);
		return result;
	}

	@Override
	public Long incr(String key) {
		Long result = jedisCluster.incr(key);
		return result;
	}

	@Override
	public Long decr(String key) {
		Long result = jedisCluster.decr(key);
		return result;
	}

	@Override
	public Long expire(String key, int seconds) {
		Long result = jedisCluster.expire(key, seconds);
		return result;
	}

	@Override
	public Long ttl(String key) {
		Long result = jedisCluster.ttl(key);
		return result;
	}

	@Override
	public Long del(String key) {
		Long result = jedisCluster.del(key);
		return result;
	}

	@Override
	public Long hdel(String key, String item) {
		Long result = jedisCluster.hdel(key, item);
		return result;
	}

}
