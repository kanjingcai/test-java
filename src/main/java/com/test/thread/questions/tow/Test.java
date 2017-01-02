package com.test.thread.questions.tow;

/**
 * 场景： 子线程循环跑30次，暂停，然后转到主线程跑40次，接着子线程循环跑30次， 暂停，然后转到主线程跑40次，如此往复，一共这样交着50次
 * 
 * @author asus
 * 
 */
public class Test {

	public static void main(String[] args) {

		final BusinessDemo businessDemo = new BusinessDemo();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 1; i <= 50; i++) {
					// 操作资源类
					businessDemo.sonBusiness(i);
				}
			}
		}).start();

		// 50轮主线程部分
		for (int i = 1; i <= 50; i++) {
			// 主线程进来一次40次
			businessDemo.mainBusiness(i);
		}
	}
}
