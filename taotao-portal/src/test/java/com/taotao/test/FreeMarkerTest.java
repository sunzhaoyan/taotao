package com.taotao.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreeMarkerTest {

	@Test
	public void testFreeMarker() {
		// 第一步：把freemarker的jar包添加到工程中
		// 第二步：freemarker的运行不依赖web容器，可以在java工程中运行。创建一个测试方法进行测试。
		// 第三步：创建一个Configration对象
		Configuration configuration = new Configuration(Configuration.getVersion());
		// 第四步：告诉config对象模板文件存放的路径。
		try {
			configuration.setDirectoryForTemplateLoading(
					new File("D:\\Workspaces\\taotao\\taotao-portal\\src\\main\\webapp\\WEB-INF\\ftl"));
			// 第五步：设置config的默认字符集。一般是utf-8
			configuration.setDefaultEncoding("utf-8");
			// 第六步：从config对象中获得模板对象。需要制定一个模板文件的名字。
			Template template = configuration.getTemplate("first.ftl");
			// 第七步：创建模板需要的数据集。可以是一个map对象也可以是一个pojo，把模板需要的数据都放入数据集。
			Map<String, Object> root = new HashMap<String, Object>();
			root.put("title", "测试");
			Student student = new Student(123l, "szy", "hb");
			root.put("student", student);
			List<String> list = new ArrayList<String>();
			list.add("a");
			list.add("b");
			list.add("c");
			root.put("lists", list);
			// 第八步：创建一个Writer对象，指定生成的文件保存的路径及文件名。
			FileWriter fileWriter = new FileWriter(
					"D:\\Workspaces\\taotao\\taotao-portal\\src\\main\\webapp\\WEB-INF\\html\\first.html");
			// 第九步：调用模板对象的process方法生成静态文件。需要两个参数数据集和writer对象。
			template.process(root, fileWriter);
			// 第十步：关闭writer对象。
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}

	}
}
