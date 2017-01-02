package com.test.thread.questions.three;

import java.util.concurrent.CountDownLatch;

/**
 * 控制线程执行的顺序， 假如有三个任务，第三个任务必须是前两个任务执行完毕之后才执行
 * 
 * 
 *  CountDownLatch.await() 方法在倒计数为0之前会阻塞当前线程
 *  
 * 
 * @author kanjc
 * 
 */
public class TestCountDownLatch {

	public static void main(String[] args) {
		final CountDownLatch count = new CountDownLatch(2);

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("第一个任务执行完毕！");
				count.countDown();
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("第二个任务执行完毕！");
				count.countDown();
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					count.await();   // 会阻塞在这里等待 count里的count变为0；
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("第三个任务执行完毕！");
			}
		}).start();

	}

}
