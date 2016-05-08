package com.test.queue;

import java.util.concurrent.ArrayBlockingQueue;

public class TestBlockingQueue {

	public static void main(String[] args) {
		ArrayBlockingQueue<Integer> bq = new ArrayBlockingQueue<Integer>(5);
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			System.out.println(bq.add(i));
		}
		System.out.println(bq.toArray(new Integer[bq.size()]));
	}
}
