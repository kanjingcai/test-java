package com.test.proxy.my;

import java.lang.reflect.Method;

/**
 * 自定义的动态处理接口，规范处理类的行为
 * @author asus
 *
 */
public interface MyInvocationHandler {

	public Object invoke(Object proxy, Method method,Object obj) throws Throwable;
	
}
