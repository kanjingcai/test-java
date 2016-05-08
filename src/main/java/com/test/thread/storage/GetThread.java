package com.test.thread.storage;

/**
 * 消费者
 * 
 * @date 2016-5-8
 * @author kanjc
 */
public class GetThread implements Runnable {

	private Student s;

	public GetThread(Student s) {
		this.s = s;
	}

	@Override
	public void run() {
		while (true) {
			System.out.println("消费数据:" + s.get());
		}
	}

}
