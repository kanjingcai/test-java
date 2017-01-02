package com.test.thread.wait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * 通过CountDownLatch来实现实时通知
 * 
 * @author asus
 * 
 */
public class ListAdd3 {

	private volatile List<String> list = new ArrayList<>();

	public void add() {
		list.add("test");
	}

	public int size() {
		return list.size();
	}

	public static void main(String[] args) {
		final ListAdd3 list1 = new ListAdd3();
		final CountDownLatch countDownLatch = new CountDownLatch(1);
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					for (int i = 0; i < 10; i++) {
						list1.add();
						System.out.println("当前线程："
								+ Thread.currentThread().getName() + "增加了一个元素");
						Thread.sleep(500);

						if (list1.size() == 5) {
							System.out.println("已发出通知..");
							countDownLatch.countDown();
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}, "t1");

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				if (list1.size() != 5) {
					try {
						countDownLatch.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("当前线程收到通知："
							+ Thread.currentThread().getName()
							+ "， list size = 5 线程停止。。");
					throw new RuntimeException();
				}
			}
		}, "t2");

		t2.start();
		t1.start();

	}
}
