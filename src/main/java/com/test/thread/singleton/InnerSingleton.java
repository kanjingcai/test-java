package com.test.thread.singleton;

/**
 * 静态内部类实现单列，最安全
 * @author asus
 *
 */
public class InnerSingleton {

	private static class Singletion {
		private static Singletion single = new Singletion();
	}

	public static Singletion getInstance() {
		return Singletion.single;
	}

}
