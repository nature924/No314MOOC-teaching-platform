package com.test;

import java.util.UUID;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.FillinDAO;
import com.entity.Fillin;
import com.util.VeDate;

public class FillinTest {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext resource = new ClassPathXmlApplicationContext("springmvc-servlet.xml");
		FillinDAO fillinDAO = (FillinDAO) resource.getBean(FillinDAO.class);
		for (int i = 0; i < 50; i++) {
			Fillin fillin = new Fillin();
			fillin.setAddtime(VeDate.getStringDateShort());
			fillin.setCorrect("正确答案" + i);
			fillin.setParsing("解析解析解析" + i);
			fillin.setFillinid(UUID.randomUUID().toString().replace("-", ""));
			fillin.setQuestion("问题问题问题____问题问题问题" + i);
			fillin.setSectionxid("S20210520102135731");//
			fillin.setCourseid("C20210520100541226");
			fillinDAO.insertFillin(fillin);
		}
	}
}
