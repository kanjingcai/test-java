package com.test.interview;

/**
 * 面试题
 * 
 * 反转 int类型的整数
 * 
 * @author kanjc
 * 
 */
public class ReverseTest {

	public int reverse(int a) {
		int result = 0;
		while (a > 0) {
			result = result * 10;
			result += a % 10;

			a = a / 10;
		}
		return result;
	}

	public int convert(int num) {
		int result = 0;

		if (num == 0) {
			return result;
		}

		int sign = num / Math.abs(num);
		num *= sign;

		while (num > 0) {
			int i = num % 10;
			num = num / 10;

			result = result * 10 + i;
		}

		return result * sign;
	}

	public int myReserve(int oriNum) {
		int tempNum = oriNum, count, result = 0;
		for (count = 0; tempNum > 0; tempNum /= 10, count++)
			;
		// 算出该数有多少位

		while (oriNum > 0) {
			int num = oriNum % 10;// 取出该位上的数.
			for (int i = 1; i < count; i++) {// count标识当前正在处理第几位数.
				num *= 10;
			}
			count--;// 标识向前移一位.
			result += num;
			oriNum /= 10;// 切掉处理过的位数.
		}

		return result;
	}

	public int rev(int x) {
		int head = x / 10;
		int tail = x % 10;
		long re = 0;

		while (head != 0 || tail != 0) {
			re = re * 10 + tail;
			tail = head % 10;
			head = head / 10;
		}

		re = re < Integer.MIN_VALUE ? 0 : re;
		re = re > Integer.MAX_VALUE ? 0 : re;
		return (int) re;  
	}

	public static void main(String[] args) {
		ReverseTest test = new ReverseTest();
		System.out.println(test.rev(487));
	}

}
