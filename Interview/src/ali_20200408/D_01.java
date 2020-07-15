package ali_20200408;

import java.util.Scanner;

/**
 * 阿里笔试
 *
 * @author wulling1024@163.com
 * @version 1.0
 * @since 2020-04-08  15:52:52
 */
public class D_01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		System.out.println(func(arr, k));
	}

	static int func(int[][] arr, int k) {
		return 0;
	}
}
