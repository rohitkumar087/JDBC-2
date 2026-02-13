package com.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(JavaConfig.class);
		Object obj = ac.getBean("stdObj");
		Object obj2 = ac.getBean("stdObj2");
		
		System.out.println(obj);
		System.out.println(obj2);
		
	}

}
