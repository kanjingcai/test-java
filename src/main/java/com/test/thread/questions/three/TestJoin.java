package com.test.thread.questions.three;

/***
 * 
 * 控制线程执行的顺序， 假如有三个任务，第三个任务必须是前两个任务执行完毕之后才执行
 * 
 * 在很多情况下，主线程生成并起动了子线程，如果子线程里要进行大量的耗时的运算，主线程往往将于子线程之前结束，但是如果主线程处理完其他的事务后，
 * 需要用到子线程的处理结果，也就是主线程需要等待子线程执行完成之后再结束，这个时候就要用到join()方法了
 * 
 * @author asus
 * 
 */
public class TestJoin {

	public static void main(String[] args) {

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("第一个任务执行完毕！");
			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("第二个任务执行完毕！");
			}
		});

		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("第三个任务执行完毕！");
			}
		});

		t1.start();
		t2.start();
		try {
			t1.join(); // 阻塞，
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		t3.start();
	}

}
