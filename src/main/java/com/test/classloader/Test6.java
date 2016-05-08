package com.test.classloader;

class Parent3 {

	static int a = 3;

	static {
		System.out.println("Parent3 static ..");
	}

	static void doSomething() {
		System.out.println("do something ..");
	}
}

class Chind3 extends Parent3 {

	// 只有当程序访问的静态变量或静态方法确实在当前类或当前接口中定义时，才可以认为对类或接口的主动使用，即类初始化
	static {
		System.out.println("Chind3 static ..");
	}
}

public class Test6 {

	public static void main(String[] args) {
		System.out.println(Chind3.a);

		Chind3.doSomething();
	}
}
