package com.taotao.test;

import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class HttpClientTest {
	// 第一步：把HttpClient使用的jar包添加到工程中。
	// 第二步：创建一个HttpClient的测试类
	// 第三步：创建测试方法。
	// 第四步：创建一个HttpClient对象
	// 第五步：创建一个HttpGet对象，需要制定一个请求的url
	// 第六步：执行请求。
	// 第七步：接收返回结果。HttpEntity对象。
	// 第八步：取响应的内容。
	@Test
	public void HttpGetTest() throws Exception {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("http://www.itheima.com");
		CloseableHttpResponse response = httpClient.execute(httpGet);
		HttpEntity entity = response.getEntity();
		String html = EntityUtils.toString(entity);
		System.out.println(html);
		response.close();
		httpClient.close();
	}

	@Test
	public void HttpPostTest() throws Exception {
		// 第一步：创建一个httpClient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// 第二步：创建一个HttpPost对象。需要指定一个url
		HttpPost post = new HttpPost("http://localhost:8082/postTest.html");
		// 第三步：创建一个list模拟表单，list中每个元素是一个NameValuePair对象
		ArrayList<NameValuePair> list = new ArrayList<NameValuePair>();
		list.add(new BasicNameValuePair("name", "张三"));
		list.add(new BasicNameValuePair("pass", "123"));
		// 第四步：需要把表单包装到Entity对象中。StringEntity
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, "utf-8");
		post.setEntity(entity);
		// 第五步：执行请求。
		CloseableHttpResponse response = httpClient.execute(post);
		// 第六步：接收返回结果
		HttpEntity httpEntity = response.getEntity();
		String string = EntityUtils.toString(httpEntity);
		System.out.println(string);
		// 第七步：关闭流。
		response.close();
		httpClient.close();

	}
}
