package com.test.thread.sync;

/**
 * 锁对象的改变问题
 * 
 * @author asus
 * 
 */
public class ChangeLock {

	private String lock = "lock";

	private void method() {
		synchronized (lock) {
			try {
				System.out.println("当前线程：" + Thread.currentThread().getName()
						+ "开始");
				lock = "change lock";
				Thread.sleep(2000);
				System.out.println("当前线程：" + Thread.currentThread().getName()
						+ "结束");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		final ChangeLock lock = new ChangeLock();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				lock.method();
			}
		}, "t1");

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				lock.method();
			}
		}, "t2");

		t1.start();

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t2.start();
	}
}
