package com.test.proxy.jdk;

import java.io.FileOutputStream;
import java.lang.reflect.Proxy;

import sun.misc.ProxyGenerator;

public class Test {

	/**
	 * jdk只能代理接口
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception{
		People p = (People)Proxy.newProxyInstance(People.class.getClassLoader(),
				new Class[] { People.class }, new ProxyHandler(new zhangshan()));
		try {
			p.eat();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println(p.getClass().getName());
		
		createProxyFile();
	}

	
	public static void createProxyFile() throws Exception{
		byte[] data = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{People.class});
		FileOutputStream out = new FileOutputStream("$Proxy0.class");
		out.write(data);
		out.close();
	}
	
}
