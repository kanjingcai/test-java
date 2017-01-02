package com.test.proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.core.DefaultGeneratorStrategy;
import net.sf.cglib.core.GeneratorStrategy;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class TestCglib {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, ".");
		
		/**
		 * cglib可以代理类和接口
		 */
		WangWu ww = new WangWu();
		Enhancer enhancer = new Enhancer();
		enhancer.setCallback(new ProxyHandlerCglib());
		enhancer.setSuperclass(ww.getClass());
		
		WangWu proxy =  (WangWu) enhancer.create();
		System.out.println(proxy.eat());
		
		System.out.println(proxy.getClass().getName());
		
		System.out.println("===================");
		test();
		
		
	}
	
	public static void test() {
		WangWu proxy = (WangWu) Enhancer.create(WangWu.class, new MethodInterceptor(){
			@Override
			public Object intercept(Object paramObject, Method method,
					Object[] paramArrayOfObject, MethodProxy paramMethodProxy)
					throws Throwable {
				System.out.println("++++++++++++");
				return paramMethodProxy.invokeSuper(paramObject, paramArrayOfObject);
			}
			
		});
		proxy.eat();
		System.out.println(proxy.getClass().getName());
	}

}
