package com.test.thread.questions.three;

import java.util.concurrent.Semaphore;

/**
 * 
 * http://ifeve.com/concurrency-semaphore/
 * 
 * @author asus
 *
 */
public class TestSemaphore {

	public static void main(String[] args) {
		// 只允许2个线程同时访问
		final Semaphore count = new Semaphore(2);

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					// 获取许可
					count.acquire();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("第一个任务执行完毕！");
				// 访问完后，释放
				count.release();
			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					// 获取许可
					count.acquire();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("第二个任务执行完毕！");
				// 访问完后，释放
				count.release();
			}
		});

		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					// count.acquire(2); //获取两个，代表上面两个任务已经执行完毕
					int a = count.availablePermits();
					System.out.println(a);
					while (a != 2) {
						a = count.availablePermits();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("第三个任务执行完毕！");
			}
		});

		t1.start();
		t2.start();
		t3.start();
	}

}
