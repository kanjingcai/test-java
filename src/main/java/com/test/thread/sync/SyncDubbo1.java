package com.test.thread.sync;

/**
 * synchronized的重入
 * 
 * @author asus
 * 
 */
public class SyncDubbo1 {

	public synchronized void method1() {
		System.out.println("method1...");
		method2();
	}

	public synchronized void method2() {
		System.out.println("method2...");
		method3();
	}

	public synchronized void method3() {
		System.out.println("method3...");
	}

	public static void main(String[] args) {
		final SyncDubbo1 sd = new SyncDubbo1();
		new Thread(new Runnable() {
			@Override
			public void run() {
				sd.method1();
			}
		}).start();
	}

}
