package com.test.classloader;

class FinalTest {

	// 标记为final时， 编译时的常量，编译时候已经计算出结果。当变量运行时才能确定时值，才会初始化
	public static final int x = 6 / 3;

	// static编译时常量还是运行时常量，后者才会初始化类
	static {
		System.out.println("FinalTest static block");
	}

}

public class Test2 {

	public static void main(String[] args) {
		System.out.println(FinalTest.x);
	}
}
