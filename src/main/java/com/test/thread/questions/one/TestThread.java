package com.test.thread.questions.one;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三个线程循环打印ABC10次的几种解决方法
 * 
 * http://www.tuicool.com/articles/2mqI7n
 * 
 * @author Administrator
 * 
 */
public class TestThread {

	private static int i = 0;
	
	public static void main(String[] args) {
		final Lock lock = new ReentrantLock();
		new Thread(new Runnable() {
			@Override
			public void run() {
				lock.lock();
				if (i % 3 == 1) {
					System.out.println("A");
				}
				i ++;
				lock.unlock();
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				lock.lock();
				if (i % 3 == 2) {
					System.out.println("B");
				}
				i ++;
				lock.unlock();
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				lock.lock();
				if (i % 3 == 0) {
					System.out.println("C");
				}
				i ++;
				lock.unlock();
			}
		}).start();

	}

}
