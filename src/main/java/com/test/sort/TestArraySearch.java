package com.test.sort;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TestArraySearch {

	public static void main(String[] args) {
		long[] arr = new long[10000000];
		random(arr);
		long start = System.currentTimeMillis();
		long srarch = (int) (Math.random() * arr.length);
		System.out.println("查找数字：" + srarch);
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == srarch) {
				System.out.println("第一种，数据已找到,下标为：" + i + "，值为：" + arr[i]);
				break;
			}
		}
		System.out.println("第一种，总时间：" + (System.currentTimeMillis() - start));
		
		start = System.currentTimeMillis();
		boolean b = Arrays.asList(arr).contains(srarch);
		if(b) {
			System.out.println("数据已找到：" + b);
		}
		System.out.println("第二种，总时间：" + (System.currentTimeMillis() - start));
		
		
		start = System.currentTimeMillis();
		for (long l : arr) {
			if(l == srarch) {
				System.out.println("第三种，数据已找到,下标为：" + l + "，值为：" + l);
				break;
			}
		}
		System.out.println("第三种，总时间：" + (System.currentTimeMillis() - start));
		
	}

	
	public static boolean useList(String[] arr, String targetValue) {
	    return Arrays.asList(arr).contains(targetValue);
	}
	
	
	public static boolean useSet(String[] arr, String targetValue) {
	    Set<String> set = new HashSet<String>(Arrays.asList(arr));
	    return set.contains(targetValue);
	}
	
	public static void random(long[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (long) (Math.random() * arr.length);
		}
	}

}
