package com.test.thread.questions.tow;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 * @author asus
 * 
 */
public class ThreadScopeDate {

	// 因为每一个线程对象都是唯一数据的
	private static Map<Thread, Integer> buyThreadForDateMap = new ConcurrentHashMap<>();

	public static void main(String[] args) {
		// 模仿客户端点击购买产生的每一个线程
		for (int i = 0; i < 2; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					int date = new Random().nextInt();
					// 展示价格
					System.out.println("产生的线程名称："
							+ Thread.currentThread().getName()
							+ ",has put date:" + date);
					buyThreadForDateMap.put(Thread.currentThread(), date);
					
					//A模块处理当前数据
					new A().get();
					
					//B模块处理当前数据
					new B().get();
				}
			}).start();
		}
	}

	// A处理模块
	static class A {
		// 拿每个线程带来的数据进行处理
		public int get() {
			int date = buyThreadForDateMap.get(Thread.currentThread());
			// 业务处理
			System.out.println(Thread.currentThread().getName()
					+ "进入A模块，处理的数据是:" + date);
			return date;
		}
	}

	// A处理模块
	static class B {
		// 拿每个线程带来的数据进行处理
		public int get() {
			int date = buyThreadForDateMap.get(Thread.currentThread());
			// 业务处理
			System.out.println(Thread.currentThread().getName()
					+ "进入B模块，处理的数据是:" + date);
			return date;
		}
	}
}
