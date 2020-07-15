package Recursion;

import java.util.Scanner;

/**
 * @Author wulling1024
 * @Create 2020-03-11  16:39
 * @Description 爬楼梯 ，每步只能上一格或者两格
 */
public class T_002 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			int[] dp = new int[n + 1];
			for (int i = 1; i < n + 1; i++) {
				if (i == 1) {
					dp[i] = 1;
				} else if (i == 2) {
					dp[i] = 2;
				} else {
					dp[i] = dp[i - 1] + dp[i - 2];
				}
			}
			System.out.println(dp[n]);
		}
	}
}
