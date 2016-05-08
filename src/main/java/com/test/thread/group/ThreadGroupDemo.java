package com.test.thread.group;

/**
 * 线程组：把多个线程组合到一起
 * 它可以对一组线程进行分类管理，Java允许程序直接对线程组进行控制
 * 
 * @date 2016-5-8
 * @author kanjc
 */
public class ThreadGroupDemo {

	public static void main(String[] args) {
		method1();
		
		//修改线程所在的组
		method2();
		
		//t1.start();
		//t2.start();
	}

	private static void method2() {
		ThreadGroup tg = new ThreadGroup("线程组");
		
		MyRunnable my = new MyRunnable();
		
		Thread t1 = new Thread(tg, my, "t1");
		Thread t2 = new Thread(tg, my, "t2");
		
		System.out.println(t1.getThreadGroup().getName());
		System.out.println(t2.getThreadGroup().getName());
		
		System.out.println(Thread.currentThread().getThreadGroup().getName());
		
		//设置组后台线程，表示该组的线程都是守护线程
		tg.setDaemon(true);
	}

	private static void method1() {
		MyRunnable my = new MyRunnable();
		
		Thread t1 = new Thread(my, "t1");
		Thread t2 = new Thread(my, "t2");
		
		//获取分组
		ThreadGroup tg1 = t1.getThreadGroup();
		ThreadGroup tg2 = t2.getThreadGroup();
		
		//线程组名称
		String name1 = tg1.getName();
		String name2 = tg2.getName();
		System.out.println(name1);
		System.out.println(name2);

		//默认情况下，所有的线程都属于同一个组
		System.out.println(Thread.currentThread().getThreadGroup().getName());
	}

}
