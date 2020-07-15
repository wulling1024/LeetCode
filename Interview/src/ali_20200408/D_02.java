package ali_20200408;

import java.util.Scanner;

/**
 * 阿里笔试二
 *
 * @author wulling1024@163.com
 * @version 1.0
 * @since 2020-04-08  15:54:54
 */
public class D_02 {

	public static void main(String[] args) {
		// 获取数据信息
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[][] arr = new int[T][4];
		for (int i = 0; i < T; i++) {
			for (int j = 0; j < 4; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int[] result = new int[T];
		for (int i = 0; i < T; i++) {
			result[i] = func(arr[i]);
		}
		for (int i : result) {
			System.out.println(i);
		}
	}

	static int func(int[] array) {
		int n = array[0];
		int m = array[1];
		int a = array[2];
		int b = array[3];
		// 木头人数组
		int[] arr = new int[m];
		for (int e : arr) {
			e = a;
		}
		return func2(n, arr, b);
	}

	static int func2(int n, int[] arry, int b) {
		// 结果值
		int result = 0;
		if (n < arry[0]) {
			return result;
		} else if (n == arry[0]) {
			if (b > arry.length) {
				return arry.length;
			} else {
				return b;
			}
		} else {
			if (b > arry[0]) {
				result += 2 * b - 1;
			}
			int m = n - arry[0];
			result += func2(m, arry, b);
		}
		return result;
	}
}
