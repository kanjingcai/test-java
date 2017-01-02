package com.test.proxy.my;

import java.lang.reflect.Proxy;

import com.test.proxy.jdk.People;
import com.test.proxy.jdk.ProxyHandler;
import com.test.proxy.jdk.zhangshan;

public class Test {

	public static void main(String[] args) throws Exception {
		People p = (People) Proxy.newProxyInstance(
				People.class.getClassLoader(), new Class[] { People.class },
				new ProxyHandler(new zhangshan()));
		try {
			p.eat();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("--------------JDK实现动态代理结束------------");
		

		People p1 = (People)MyProxy.createProxyInstance(People.class.getClassLoader(),
				People.class, new MyProxyHandler(new zhangshan()));
		try {
			p1.eat();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("==============自定义动态代理结束=========");

	}

}
