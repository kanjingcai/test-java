package com.test.classloader;

import java.util.Random;

class FinalTest2 {

	// 当常量定义为final，并且为static时，如果变量的值是编译时确定，
	// 那么类不会初始化，反之变量值是运行时才能确定，那么类才会初始化
	public final static int x = new Random().nextInt(100);

	static {
		System.out.println("FinalTest2 static block");
	}
}

public class Test3 {

	public static void main(String[] args) {
		System.out.println(FinalTest2.x);
	}
}
