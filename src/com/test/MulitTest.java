package com.test;

import java.util.UUID;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.MulitDAO;
import com.entity.Mulit;
import com.util.VeDate;

public class MulitTest {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext resource = new ClassPathXmlApplicationContext("springmvc-servlet.xml");
		MulitDAO mulitDAO = (MulitDAO) resource.getBean(MulitDAO.class);
		for (int i = 0; i < 50; i++) {
			Mulit mulit = new Mulit();
			mulit.setAddtime(VeDate.getStringDateShort());
			mulit.setAnswera("A答案" + i);
			mulit.setAnswerb("B答案" + i);
			mulit.setAnswerc("C答案" + i);
			mulit.setAnswerd("D答案" + i);
			mulit.setAnswere("E答案" + i);
			mulit.setCorrect("");
			if (i % 5 == 0) {
				mulit.setCorrect("A,C,D");
			} else if (i % 5 == 1) {
				mulit.setCorrect("B,D");
			} else if (i % 5 == 2) {
				mulit.setCorrect("C,E");
			} else if (i % 5 == 3) {
				mulit.setCorrect("A,D,E");
			} else if (i % 5 == 3) {
				mulit.setCorrect("C,D");
			}
			mulit.setCourseid("C20210520100541226");
			mulit.setSectionxid("S20210520102135731");
			mulit.setMulitid(UUID.randomUUID().toString().replace("-", ""));
			mulit.setParsing("多选解析解析解析解析" + i);
			mulit.setQuestion("多选问题问题问题" + i);
			mulitDAO.insertMulit(mulit);
		}
	}
}
