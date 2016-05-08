package com.test.thread;

import java.util.Date;

public class ThreadTest {

	public static void main(String[] args) {
		UnsafeSequence us = new UnsafeSequence();
		Thread thread = new Thread(us);
		thread.start();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//thread.interrupt();
		us.flag = false;
	}

}

class UnsafeSequence implements Runnable {

	boolean flag = true;
	
	public void run() {
		while(flag) {
			System.out.println(new Date());
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				return;
			}
		}
	}
}
