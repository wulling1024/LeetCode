package exam;

import java.util.Scanner;

/**
 * @Author wulling1024
 * @Create 2020-03-12  19:30
 * @Description
 */
public class Test_01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		String[] str = new String[2];
		int i = 0;
		while (i < 2) {
			str[i++] = sc.nextLine();
		}
		System.out.println(func(str));
		System.out.println(Solution.sum(str));
	}

	static int func(String[] str) {
		int len = str[0].length();
		int[][] arr = new int[2][len];
		char[] char1 = str[0].toCharArray();
		char[] char2 = str[1].toCharArray();
		for (int i = 0; i < len - 1; i++) {
			if (char1[i] != 'X') {
				if (char1[i + 1] != 'X') {
					arr[0][i] += 1;
				}
				if (char2[i + 1] != 'X') {
					arr[0][i] += 1;
				}
			} else {
				arr[0][i] = 0;
			}
			if (char2[i] != 'X') {
				if (char1[i + 1] != 'X') {
					arr[1][i] += 1;
				}
				if (char2[i + 1] != 'X') {
					arr[1][i] += 1;
				}
			} else {
				arr[1][i] = 0;
			}
		}
		if (char1[len - 1] != 'X') {
			arr[0][len - 1] = 1;
		}
		if (char2[len - 1] != 'X') {
			arr[1][len - 1] = 1;
		}
		int result = 1;
		for (int i = 0; i < len; i++) {
			int temp = Math.max(arr[0][i], arr[1][i]);
			result = result * temp;
		}
		if (result != 0) {
			return result;
		}
		return -1;
	}
}

class Solution {
	public static int sum(String[] str) {
		char[][] chars = new char[][]{str[0].toCharArray(), str[1].toCharArray()};
		int[][] dp = new int[2][str[0].length()];
//		for(int i = 0; i<2; i++){
		for (int j = 0; j < str[0].length(); j++) {
			if (j == 0) {
				if (chars[0][j] != 'X') {
					dp[0][j] = 1;
				}
				if (chars[1][j] != 'X') {
					dp[1][j] = 1;
				}
			} else {
				if (chars[0][j] != 'X') {
					dp[0][j] = dp[0][j - 1] + dp[1][j - 1];
				}
				if (chars[1][j] != 'X') {
					dp[1][j] = dp[0][j - 1] + dp[1][j - 1];
				}
			}
		}
//		}
		return dp[1][str[0].length() - 1];
	}
}
