package com.test.proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 代理类
 * @author asus
 *
 */
public class ProxyHandlerCglib implements MethodInterceptor{

	@Override
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		System.out.println("开始");
		Object result = proxy.invokeSuper(obj, args);
		
		System.out.println("结束");
		return result;
	}
	
	

}
