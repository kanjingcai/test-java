package com.test.thread;

/**
 * 生产者和消费者
 * 
 * wait():释放占有的对象锁，线程进入等待池，释放cpu,而其他正在等待的线程即可抢占此锁
 * wait()和sleep()最大的不同在于wait()会释放对象锁，而sleep()不会！
 *
 */
public class ProducerConsumer {

	public static void main(String[] args) {
		SyncStack ss = new SyncStack();
		Producer p = new Producer(ss);
		Consumer c = new Consumer(ss);

		Thread t1 = new Thread(p);
		t1.start();

		Thread t2 = new Thread(c);
		t2.start();
	}

}

class WoTou {
	int id;

	public WoTou(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "WoTou [id=" + id + "]";
	}
}

class SyncStack {
	int index = 0;
	WoTou[] arrWT = new WoTou[6];

	public synchronized void push(WoTou wt) {
		while (index == arrWT.length) {
			try {
				System.out.println("push wait");
				this.wait(); // 当前线程正在访问当前方法的线程，停止
				System.out.println("push end");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.notify();

		arrWT[index] = wt;
		index++;
	}

	public synchronized WoTou pop() {
		System.out.println("pop:" + index);
		while (index == 0) {
			try {
				System.out.println("pop wait");
				this.wait();
				System.out.println("pop end");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.notify();
		return arrWT[index--];
	}

}

class Producer implements Runnable {

	SyncStack ss = null;

	Producer(SyncStack ss) {
		this.ss = ss;
	}

	public void run() {
		for (int i = 0; i < 20; i++) {
			WoTou wt = new WoTou(i);
			System.out.println("生产了：" + wt);
			ss.push(wt);
			try {
				Thread.sleep((long) (Math.random() * 200));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Consumer implements Runnable {

	SyncStack ss = null;

	Consumer(SyncStack ss) {
		this.ss = ss;
	}

	public void run() {
		for (int i = 0; i < 20; i++) {
			WoTou wt = ss.pop();
			System.out.println("消费了：" + wt);
			try {
				Thread.sleep((long) (Math.random() * 1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

}