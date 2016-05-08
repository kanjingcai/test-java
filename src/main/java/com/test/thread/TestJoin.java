package com.test.thread;

public class TestJoin {

	public static void main(String[] args) {
		MyThread t1 = new MyThread("t1");
		t1.start();

		try {
			// 合并某个线程，等待子线程结束，主线程才执行，按照顺序执行，实现了同步性
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 0; i < 10; i++) {
			System.out.println("i am main thread: "
					+ Thread.currentThread().getName());
		}
	}

}

class MyThread extends Thread {

	public MyThread(String s) {
		super(s);
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(getName());
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
