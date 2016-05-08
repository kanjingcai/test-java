package com.test.thread;

/**
 * 保证属性安全的方式
 * 
 * 1、通过synchronized
 * 2、通过join方法
 * 3、volatile不保证线程安全，只是保证对线程的读写可见性， 不加改关键字：
 */
public class TestVisibility {

	private volatile static boolean ready;

	private volatile static int number;

	private static class ReaderThread extends Thread {
		@Override
		public void run() {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println(ready);
			System.out.println(number);
		}
	}

	private static class WriteThread extends Thread {
		@Override
		public void run() {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			number = 100;
			ready = true;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread t = new WriteThread();
		t.start();
		t.setPriority(5);
		new ReaderThread().start();
	}

}
