package com.test.classloader;

class Parent {

	static int a = 3;
	static {
		System.out.println("Parent static ..");
	}

}

class Child extends Parent {

	static int b = 4;
	static {
		System.out.println("Child static ..");
	}
}

public class Test4 {

	static {
		System.out.println("Test4 static ..");
	}

	public static void main(String[] args) {
		System.out.println(Child.b);
	}

}
