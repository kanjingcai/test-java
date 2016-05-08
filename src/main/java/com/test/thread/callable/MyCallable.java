package com.test.thread.callable;

import java.util.concurrent.Callable;

/**
 * 带泛型的接口,代表指定的泛型是返回值的类型
 * 
 * 线程求和案例
 * 
 * @date 2016-5-8
 * @author kanjc
 */
public class MyCallable implements Callable<Integer> {

	private int number;

	public MyCallable(int number) {
		this.number = number;
	}

	@Override
	public Integer call() throws Exception {
		int sum = 0;
		for (int i = 1; i <= number; i++) {
			sum += i;
		}
		return sum;
	}

}
