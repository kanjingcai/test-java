package com.test.thread.ticket;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 电影票出售程序
 * 
 * @date 2016-5-8
 * @author kanjc
 */
public class SellTicket implements Runnable {

	// 定义100张票
	private int tickets = 100;

	// 定义锁对象/ 或使用synchronized
	private Lock lock = new ReentrantLock();

	@Override
	public void run() {

		while (true) {

			try {
				// 加锁
				lock.lock();

				if (tickets > 0) {
					try {
						// 认为网络延迟
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					System.out.println(Thread.currentThread().getName()
							+ "正在出售第" + (tickets--) + "张票");
				}
			} finally {
				// 释放锁
				lock.unlock();
			}

		}

	}

}
