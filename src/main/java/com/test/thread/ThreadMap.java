package com.test.thread;

import java.util.HashMap;
import java.util.UUID;

public class ThreadMap {

	public static void main(String[] args) throws Exception {
		final HashMap<String, String> map = new HashMap<String, String>(10000000);
		Thread t = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 1000000; i++) {
					new Thread(new Runnable() {
						public void run() {
							System.out.println(Thread.currentThread().getName());
							map.put(UUID.randomUUID().toString(),
									System.currentTimeMillis() + "");
						}
					}, "ftf" + i).start();
				}
				System.out.println(Thread.currentThread().getName());
			}
		}, "aaaaaa");
		t.start();
		t.join();

		System.out.println(map);
	}

}
