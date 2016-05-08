package com.test.classloader;

class CL {

	static {
		System.out.println("Class CL");
	}
}

public class Test7 {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {
		ClassLoader loader = ClassLoader.getSystemClassLoader();
		// 调用ClassLoader类的load方法加载类，并不会对类的主动使用。只完成加载类的过程，并不会初始化
		Class<?> clazz = loader.loadClass("com.test.classloader.CL");
		System.out.println("==========================");

		// 对类的主动使用，只有六种方式的主动使用
		//1.创建类的对象
		//2.访问某个类或接口的静态变量，或者对该静态变量赋值
		//3.调用该类的静态方法
		//4.反射，通过Class.forName
		//5.初始化一个类的子类
		//6.Java虚拟机启动时被标明为启动类的类（Java Test）
		clazz = Class.forName("com.test.classloader.CL");
	}
}
