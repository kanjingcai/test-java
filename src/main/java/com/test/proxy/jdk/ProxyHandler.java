package com.test.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyHandler implements InvocationHandler{

	private People people;
	
	
	public ProxyHandler(People people) {
		this.people = people;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("开始");
		method.invoke(people, args);
		System.out.println("结束");
		return null;
	}

}
