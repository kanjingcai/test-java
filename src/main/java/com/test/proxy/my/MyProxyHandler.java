package com.test.proxy.my;

import java.lang.reflect.Method;

import com.test.proxy.jdk.People;

public class MyProxyHandler implements MyInvocationHandler {

	private People people;

	public MyProxyHandler(People people) {
		this.people = people;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object obj)
			throws Throwable {
		System.out.println("开始");
		method.invoke(people, null);
		System.out.println("结束");
		return null;
	}

	public MyProxyHandler() {

	}
}
