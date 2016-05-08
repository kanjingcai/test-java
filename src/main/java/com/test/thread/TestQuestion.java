package com.test.thread;

/**
 * 面试题，打印结果是什么？
 * 
 */
public class TestQuestion implements Runnable {

	int b = 100;

	public synchronized void m1() throws Exception {
		System.out.println("m1 start!");
		b = 1000;
		Thread.sleep(5000);
		System.out.println("b:" + b);
	}

	public  void m2() throws Exception {
		System.out.println("m2 start!");
		Thread.sleep(3000);
		b = 2000;
	}
	
	public void run() {
		try {
			m1();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		TestQuestion tq = new TestQuestion();
		Thread t1 = new Thread(tq);
		t1.start();

		//Thread.sleep(1);
		tq.m2();
		System.out.println(tq.b);
	}

}
