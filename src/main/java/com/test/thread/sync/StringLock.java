package com.test.thread.sync;

/**
 * synchronized代码块对字符串，注意String常量池的缓存功能 不要使用String常量加锁，会出现死循环的问题
 * 
 * @author asus
 * 
 */
public class StringLock {

	public void method() {
		synchronized (new String("字符串常量")/*"字符串常量"*/) {
			try {
				while (true) {
					System.out.println("当前线程："
							+ Thread.currentThread().getName() + "开始");
					Thread.sleep(1000);
					System.out.println("当前线程："
							+ Thread.currentThread().getName() + "结束");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		final StringLock lock = new StringLock();
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
		t2.start();

	}
}
