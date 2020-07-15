package Recursion;

import java.util.Arrays;

/**
 * 动态规划
 *
 * 最长子序列问题：元素无需连续
 * 最长子串问题：元素需要连续
 * @author wulling1024@163.com
 * @version 1.0
 * @since 2020-04-11  11:53:53
 */
public class T_003 {
	public static void main(String[] args) {
		int[] arr = {2, 3, 1, 4, 2, 4, 5};
		System.out.println(findLongestSubsequence(arr));
		System.out.println(findLongestSubString(arr));
		System.out.println(findhuiwen("41113"));
	}

	/**
	 * 查找最长子序列
	 * @param arr
	 * @return
	 */
	static int findLongestSubsequence(int[] arr){
		// 定义 dp 数组
		int[] dp = new int[arr.length];
		Arrays.fill(dp, 1);

		for(int i = 1 ; i<dp.length; i++){
			for(int j = 0 ; j < i ; j++){
				if(arr[i] > arr[j]){
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}

		int result = dp[0];
		for(int e : dp){
			result = Math.max(result, e);
		}
		return result;
	}

	/**
	 * 查找最长子串
	 * @param arr
	 * @return
	 */
	static int findLongestSubString(int[] arr){
		int[] dp = new int[arr.length];
		Arrays.fill(dp, 1);

		for(int i = 1; i<arr.length; i++){
			if(arr[i] > arr[i-1]){
				dp[i] += dp[i-1];
			}
		}

		int result = dp[0];
		for(int e : dp){
			result = Math.max(result, e);
		}
		return result;
	}

	static int findhuiwen(String str){
		if(str.equals("")){
			return 0;
		}else if(str.length() == 1){
			return 1;
		}else{
			int[] dp = new int[str.length() + 1];
			Arrays.fill(dp, 1);
			dp[0] = 0;
			char[] chars = str.toCharArray();
			if(chars[0] == chars[1]){
				dp[2] = 2;
			}
			for(int i = 2; i < str.length(); i++){
				if(i-1-dp[i] >= 0 && chars[i] == chars[i-1-dp[i]]){
					dp[i+1] = dp[i] + 2;
				}
			}
			for(int i = 0; i<str.length()+1; i++){
				dp[str.length()] = Math.max(dp[str.length()], dp[i]);
			}
			return dp[str.length()];
		}
	}
}
