package com.test.thread.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 多线程实现方式
 *     集成Thread ，实现Runnable 或 Callable
 * 
 * @date 2016-5-8
 * @author kanjc
 */
public class CallableDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService pool = Executors.newFixedThreadPool(2);
		
		Future<Integer> obj = pool.submit(new MyCallable(100));
		Future<Integer> obj2 = pool.submit(new MyCallable(200));
		System.out.println(obj.get()); //获取返回值
		System.out.println(obj2.get());
		
		pool.shutdown();
	}
	
}
