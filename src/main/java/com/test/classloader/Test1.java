package com.test.classloader;

import com.sun.java.accessibility.util.java.awt.ButtonTranslator;

public class Test1 {

	public static void main(String[] args) throws Exception {

		Class<?> clazz = Class.forName("java.lang.String");
		System.out.println(clazz.getClassLoader()); // 打印null，说明根类的类加载器

		System.out.println(ButtonTranslator.class.getClassLoader()); // 扩展类加载器

		Class<?> clazz2 = Class.forName("com.test.classloader.C");
		System.out.println(clazz2.getClassLoader()); // 应用类加载器，系统加载器
		
	}

}

class C {

}