package Basic;

import java.util.Scanner;

/**
 * @Author wulling1024
 * @Create 2020-03-10  16:10
 * @Description 基础算法 -> 数组翻转
 */
public class Test20200310_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		int[] arr = new int[len + 2];
		arr[0] = Integer.MIN_VALUE;
		arr[len + 1] = Integer.MAX_VALUE;
		int i = 1;
		while (i < len + 1) {
			arr[i++] = sc.nextInt();
		}
		System.out.println(func(arr));
	}

	static String func(int[] arr) {
		int start = 0;
		int end = 0;
		for (int i = 1; i < arr.length - 2; i++) {
			if (arr[i] > arr[i + 1]) {
				start = i;
				while (arr[i] > arr[i + 1]) {
					i++;
				}
				end = i;
				if (arr[start] < arr[end + 1] && arr[start - 1] < arr[end]) {
					return "yes";
				}
				break;
			}
			while (arr[i] == arr[i + 1]) {
				i++;
				if (i == (arr.length - 2)) {
					return "yes";
				}
			}

		}
		return "no";
	}
}
