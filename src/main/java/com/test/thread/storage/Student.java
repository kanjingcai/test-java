package com.test.thread.storage;

public class Student {

	private String name;
	private int age;
	private boolean flag; //默认是没有数据，如果为true，则是有数据
	
	public synchronized void set(String name,int age) {
		//如果有数据，就等待
		if(this.flag) {
			try {
				this.wait();  //等待，立即释放锁，将来醒过来的时候，是从这里醒过来。
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//设置数据
		this.name = name;
		this.age = age;
		
		//修改标记
		this.flag = true; 
		this.notify();  //唤醒线程, 并不表示立马可以执行，必须得抢CPU的执行权
	}
	
	
	public synchronized Student get() {
		if(!this.flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(this.toString());
		
		//修改标记
		this.flag = false;
		this.notify();
		return this;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", flag=" + flag
				+ "]";
	}
	
}
