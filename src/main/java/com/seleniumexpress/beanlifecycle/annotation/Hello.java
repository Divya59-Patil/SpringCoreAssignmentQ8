package com.seleniumexpress.beanlifecycle.annotation;

public class Hello {
	public void init() {
		System.out.println("Init method inside the hello class");
	}
	public void destroy() {
		System.out.println("destroy method inside the hello class");
	}
}
