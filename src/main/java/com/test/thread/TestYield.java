package com.test.thread;

/**
 * Yield方法：让出CPU，给其他线程执行机会
 * @author Administrator
 *
 */
public class TestYield {

	public static void main(String[] args) {
		Thread t1 = new MyThread3("t1");
		Thread t2 = new MyThread3("t2");
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);
		t1.start();
		t2.start();
	}

}

class MyThread3 extends Thread {
	MyThread3(String s) {
		super(s);
	}

	@Override
	public void run() {
		for (int i = 1; i <= 100; i++) {
			System.out.println(getName() + ":" + i);
			if (i % 10 == 0) {
				// 让出CPU，给其他线程执行机会
				yield();
			}
		}
	}

}
