package com.test.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;

public class Test {

	public static void main(String[] args) throws Exception{
		Enhancer enhancer = new Enhancer();
		enhancer.setCallback(new ProxyHandler(new zhangshan()));
		enhancer.setSuperclass(People.class);
		
		People p = (People)enhancer.create();;
		try {
			p.eat();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println(p.getClass().getName());
		
	}

}
