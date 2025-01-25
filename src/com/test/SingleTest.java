package com.test;

import java.util.UUID;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.SingleDAO;
import com.entity.Single;
import com.util.VeDate;

public class SingleTest {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext resource = new ClassPathXmlApplicationContext("springmvc-servlet.xml");
		SingleDAO singleDAO = (SingleDAO) resource.getBean(SingleDAO.class);
		for (int i = 0; i < 50; i++) {
			Single single = new Single();
			single.setAddtime(VeDate.getStringDateShort());
			single.setAnswera("A答案" + i);
			single.setAnswerb("B答案" + i);
			single.setAnswerc("C答案" + i);
			single.setAnswerd("D答案" + i);
			if (i % 4 == 0) {
				single.setCorrect("A");
			} else if (i % 4 == 1) {
				single.setCorrect("B");
			} else if (i % 4 == 2) {
				single.setCorrect("C");
			} else if (i % 4 == 3) {
				single.setCorrect("D");
			}
			single.setCourseid("C20210520100541226");
			single.setSectionxid("S20210520102135731");
			single.setParsing("解析" + i);
			single.setQuestion("问题问题问题" + i);
			single.setSingleid(UUID.randomUUID().toString().replace("-", ""));
			singleDAO.insertSingle(single);
		}
	}

}
