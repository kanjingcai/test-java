package com.test.queue;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class TestLinkedBlockingDeque {

	public static void main(String[] args) {
		final BlockingDeque<Integer> bd = new LinkedBlockingDeque<Integer>(5);
		
		Thread th = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					try {
						bd.putFirst(i);
						System.out.println("增加元素：" + i);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		th.start();
		
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("-----end--------");
		
		System.out.println(bd.remove());
	}

}
