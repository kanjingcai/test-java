package com.test.proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class ProxyHandler implements MethodInterceptor{

	private People people;
	
	
	public ProxyHandler(People people) {
		this.people = people;
	}


	@Override
	public Object intercept(Object arg0, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		System.out.println("开始");
		method.invoke(people, args);
		proxy.invoke(people, args);
		
		System.out.println("结束");
		return null;
	}
	
	

}
