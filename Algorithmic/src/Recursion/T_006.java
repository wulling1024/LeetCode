package Recursion;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 最长公共子序列问题 -> 针对于多个字符串的比较
 *
 * @author wulling1024@163.com
 * @version 1.0
 * @since 2020-04-15  11:10:10
 */
public class T_006 {
	public static void main(String[] args) {
		String str = "wulling";
		String str2 = "wsl";
		System.out.println(func(str, str2));
	}

	static int func(String str, String str2){
		// 1、明确DP数组的含义
		int[][] dp = new int[str.length()+1][str2.length()+1];

		// 2、指定BASE CASE
		// 数组定义，元素默认为0，所以无需定义

		// 状态转移
		char[] chars = str.toCharArray();
		char[] chars1 = str2.toCharArray();
		ArrayList<Character> result = new ArrayList<Character>();
		for (int i = 1; i < str.length()+1; i++) {
			for (int j = 1; j < str2.length() + 1; j++) {
				if (chars[i - 1] == chars1[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					result.add(chars[i - 1]);
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		Iterator<Character> iterator = result.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		return dp[str.length()][str2.length()];
	}
}
