package com.seleniumexpress.beanlifecycle.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String args[]) throws Exception{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		StudentDAO dao = context.getBean("studentDao",StudentDAO.class);
		dao.selectAllRow();
		
		Hello hello = context.getBean("hello",Hello.class);
//		dao.deleteRow(2);
		context.close();
		
//		context.registerShutdownHook();
//		
//		StudentDAO dao1 = context.getBean("studentDao",StudentDAO.class);
	
	}
}
