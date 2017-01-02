package com.test.thread.questions.tow;

public class BusinessDemo {

	private boolean isShowSoThread = true;

	// 子线程先处理
	public synchronized void sonBusiness(int i) {
		while (!isShowSoThread) {
			try {
				// 子线程就在外面等待
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		for (int j = 1; j <= 30; j++) {
			System.out.println("====子线程运行第：" + i + "，轮，第：" + j + "次！");
		}
		// 厕所门打开
		isShowSoThread = false;
		// 通知主线程操作
		this.notify();

	}

	// 主线程先处理
	public synchronized void mainBusiness(int i) {
		while (isShowSoThread) {
			try {
				// 主子线程就在外面等待
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		for (int j = 1; j <= 40; j++) {
			System.out.println("++++主线程运行第：" + i + "，轮，第：" + j + "次！");
		}
		// 厕所门打开
		isShowSoThread = true;
		// 通知子线程操作
		this.notify();

	}
}
