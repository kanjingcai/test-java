package com.test.thread.anonymous;

/**
 * 匿名内部类的格式 
 *      	new 类名或者接口(){ 
 *       		重写方法 
 *       	} 
 * 
 * 本质：是该类或者接口的子类对象
 * 
 * @date 2016-5-8
 * @author kanjc
 */
public class ThreadDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//集成Thread类实现多线程
		new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					System.out.println(Thread.currentThread().getName() + ":"
							+ i);
				}
			}
		}.start();

		//实现Runnable接口来实现
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					System.out.println(Thread.currentThread().getName() + ":"
							+ i);
				}
			}
		}){}.start();
		
		//这种形式，只会允许子类对象
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					System.out.println("hello" + ":"
							+ i);
				}
			}
		}){
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					System.out.println("world" + ":"
							+ i);
				}
			}
		}.start();
	}

}
