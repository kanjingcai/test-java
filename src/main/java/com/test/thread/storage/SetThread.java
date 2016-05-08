package com.test.thread.storage;

/**
 * 生产者
 * 
 * @date 2016-5-8
 * @author kanjc
 */
public class SetThread implements Runnable {

	private Student s;

	public SetThread(Student s) {
		this.s = s;
	}

	@Override
	public void run() {
		while (true) {
			s.set("学生1", 111);
			System.out.println("生产数据:" + s);
		}

	}

}
