package com.taotao.jedis;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.taotao.rest.component.JedisClient;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

public class JedisTest {
	@Test
	public void testJedisSingle() {
		// 单机版redis测试
		Jedis jedis = new Jedis("192.168.148.128", 6379);
		jedis.set("a", "100");
		String string = jedis.get("a");
		System.out.println(string);
		jedis.close();
	}

	@Test
	public void testJedisPool() {
		// 单机版 测试jedis连接池
		JedisPool jedisPool = new JedisPool("192.168.148.128", 6379);
		Jedis jedis = jedisPool.getResource();
		jedis.set("test", "aaaa");
		String string = jedis.get("test");
		System.out.println(string);
		jedis.close();
		jedisPool.close();
	}

	@Test
	public void testJedisCluster() {
		// jedis集群
		Set<HostAndPort> nodes = new HashSet<>();
		nodes.add(new HostAndPort("192.168.148.128", 7001));
		nodes.add(new HostAndPort("192.168.148.128", 7002));
		nodes.add(new HostAndPort("192.168.148.128", 7003));
		nodes.add(new HostAndPort("192.168.148.128", 7004));
		nodes.add(new HostAndPort("192.168.148.128", 7005));
		nodes.add(new HostAndPort("192.168.148.128", 7006));
		JedisCluster jedisCluster = new JedisCluster(nodes);
		jedisCluster.set("name", "张三");
		jedisCluster.set("value", "100");
		String name = jedisCluster.get("name");
		String value = jedisCluster.get("value");
		System.out.println(name + ":" + value);
		// 系统关闭
		jedisCluster.close();
	}

	@Test
	public void testJedisClientSpring() {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"classpath:spring/applicationContext-* ");
		JedisClient jedisClient = applicationContext.getBean(JedisClient.class);
		jedisClient.set("test", "123");
		String result = jedisClient.get("test");
		System.out.println(result);
	}
}
