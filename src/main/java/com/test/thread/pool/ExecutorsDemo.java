package com.test.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池，线程池里的每一个线程结束后，并不会死亡，而是再次回到线程池中成为空闲状态，等待下一个对象来使用
 * 
 * 实现线程池：
 *     A：创建线程池对象，Executeor.newFixedThreadPool()
 *     B: 线程池执行：Runnable对象或Callable对象的线程
 *     C：调用Future<?> submit(Runnable task), <T> Future<T> submit(Callable<T> task)
 * @date 2016-5-8
 * @author kanjc
 */
public class ExecutorsDemo {

	public static void main(String[] args) {
		//创建一个线程池对象
		ExecutorService pool = Executors.newFixedThreadPool(2);
		
		//执行线程
		pool.submit(new MyRunnable());
		pool.submit(new MyRunnable());
		
		//结束线程
		pool.shutdown();
	}
	
}
