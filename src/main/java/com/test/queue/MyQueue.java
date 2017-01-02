package com.test.queue;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class MyQueue {

	// 1需要一个袁术的集合
	private LinkedList<Object> list = new LinkedList<>();

	// 2需要一个计数器
	private AtomicInteger count = new AtomicInteger(0);

	// 3需要制定上限和下限
	private int minSize = 0;
	private int maxSize;

	// 4构造方法初始化上限
	public MyQueue(int size) {
		this.maxSize = size;
	}

	// 5.初始化一个对象用于加锁
	private final Object lock = new Object();

	public void put(Object obj) {
		synchronized (lock) {
			while (count.get() == this.maxSize) {
				try {
					// 如果当前集合元素等于最大的长度，就等待
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			// 1加入元素
			list.add(obj);
			// 2计数器累计
			count.incrementAndGet();
			// 3通知另外一个线程
			lock.notify();
			System.out.println("新加入元素：" + obj);
		}
	}

	public Object take() {
		Object ret = null;
		synchronized (lock) {
			while (count.get() == this.minSize) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			// 1.移除元素操作
			ret = list.removeFirst();
			// 2.计数器递减
			count.decrementAndGet();
			// 3.唤醒另外一个线程
			lock.notify();
		}
		return ret;
	}

	public int getSize() {
		return this.count.get();
	}

	public static void main(String[] args) {
		final MyQueue mq = new MyQueue(5);
		mq.put("a");
		mq.put("b");
		mq.put("c");
		mq.put("d");
		mq.put("e");

		System.out.println("当前容器的长度：" + mq.getSize());

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				mq.put("f");
				mq.put("g");
			}
		});
		t1.start();

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				Object o1 = mq.take();
				System.out.println("移除的元素为：" + o1);
				Object o2 = mq.take();
				System.out.println("移除的元素为："+ o2);
			}
		});
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t2.start();

	}
}
