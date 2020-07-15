/**
 * @Author wulling1024
 * @Create 2020-03-19  17:08
 * @Description 动态规划 -> 求最长有效括号
 */
class Solution {
	public static int longestValidParentheses(String s) {
		char[] chars = s.toCharArray();
		int[] dp = new int[s.length()];
		int max = 0;
		if (s.length() <= 1) {
			return 0;
		}
//		if(s.length() == 2){
//			if(chars[0] == '(' && chars[1] == ')'){
//				return 2;
//			}else{
//				return 0;
//			}
//		}
		//精妙呀，用条件运算来解决数组越界的问题
		for (int i = 1; i < s.length(); i++) {
			if (chars[i] == ')') {
				if (chars[i - 1] == '(') {
					dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
				}
				if (chars[i - 1] == ')' && (i - 1 - dp[i - 1]) >= 0 && chars[i - 1 - dp[i - 1]] == '(') {
					dp[i] = dp[i - 1] + ((i - 1 - dp[i - 1] - 1) >= 0 ?
						   dp[i - 1 - dp[i - 1] - 1] : 0) + 2;

				}
				max = Math.max(max, dp[i]);
			}
		}
		return max;
	}
}

public class Demo {
	public static void main(String[] args) {
		String str = "()(())";
		System.out.println(Solution.longestValidParentheses(str));
	}
}
