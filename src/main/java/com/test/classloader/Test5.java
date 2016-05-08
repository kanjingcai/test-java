package com.test.classloader;

class Parent2 {
	static int a = 3;

	static {
		System.out.println("Parent2 static ..");
	}
}

class Child2 extends Parent2 {

	static int b = 4;
	static {
		System.out.println("Child2 static ..");
	}

}

public class Test5 {

	static {
		System.out.println("Test5 static ..");
	}

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Parent2 parent;
		System.out.println("-------------");
		parent = new Parent2();

		System.out.println(Parent2.a);

		System.out.println(Child2.b);
	}

}
