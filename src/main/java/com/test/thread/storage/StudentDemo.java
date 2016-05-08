package com.test.thread.storage;

/**
 * 生产者与消费者
 * 
 *     资源类：Student
 *     设置学生数据：SetThread（生产者）
 *     获取学生数据：GetThread（消费者）
 *     测试类：StudentDemo
 * 
 * 使用等待唤醒几只：
 * 		Object类提供三个方法
 *			wait():等待
 * 			notify():唤醒单个线程
 * 			notifyAll():唤醒所有线程
 *   为什么这些方法不定义在Thread类中？
 *     这些方法的调用，必须通过锁对象调用，而synchronized使用的锁对象是任意锁对象			
 * 
 * @date 2016-5-8
 * @author kanjc
 */
public class StudentDemo {

	public static void main(String[] args) {
		//创建资源
		Student s = new Student();
		
		//设置和获取资源
		SetThread st = new SetThread(s);
		GetThread gt = new GetThread(s);
		
		//线程类
		Thread t1 = new Thread(st);
		Thread t2 = new Thread(gt);
		
		t1.start();
		t2.start();
	}
	
}
