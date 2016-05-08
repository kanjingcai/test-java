package com.test.thread.lock;

/**
 * 同步的弊端 　　　　
 *   	A:效率低 　　 　
 *      B：容易产生死锁
 *     
 * 死锁：
 * 		两个或多个以上的线程在争夺资源的过程中，发送的一种互相等待的现象
 *      
 * 举例：
 *     
 *     
 * @date 2016-5-8
 * @author kanjc
 */
public class DieLockDemo {

	public static void main(String[] args) {
		DieLock dl1 = new DieLock(true); 
		DieLock dl2 = new DieLock(false); 
		
		dl1.start();
		dl2.start();
	}
	
}
