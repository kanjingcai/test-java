package com.test.timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 定时器： 可以指定的时间做某件事情，还可以重复的做某件事情
 * 依赖Timer和TimerTask两个类
 * 
 * @date 2016-5-8
 * @author kanjc
 */
public class TimerDemo {

	public static void main(String[] args) {
		Timer t = new Timer();
		//3秒后执行
		//t.schedule(new MyTask(), 3000);
		//结束任务
		//t.schedule(new MyTask(t), 3000);
		
		t.schedule(new MyTask2(), 3000,2000);
	}
	
}

class MyTask extends TimerTask {

	private Timer t;
	public MyTask(Timer t) {
		this.t = t;
	}
	
	@Override
	public void run() {
		System.out.println("任务执行了。。。");
		t.cancel();
	}
	
}

class MyTask2 extends TimerTask {
	@Override
	public void run() {
		System.out.println("任务执行了。。。");
	}
	
}
