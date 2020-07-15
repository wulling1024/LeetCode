package Recursion;

import java.util.Arrays;

/**
 * 动态规划：背包问题
 * 1、背包：重量 <= W, 求解最大价值
 * 2、每件物品：重量 wt[i], 价值 val[i]
 * 3、有可能每件物品还有装入次数的限制
 * @author wulling1024@163.com
 * @version 1.0
 * @since 2020-04-11  15:40:40
 */
public class T_004 {
	public static void main(String[] args) {
		int[] wt = {1, 3, 2, 5, 4};
		int[] val = {3, 3, 3, 7, 8};
		int M = 4;
		System.out.println(findMaxValue(M, wt, val));
		System.out.println(findMaxValue2(M, wt, val));
		System.out.println(findMaxValue3(M, wt, val));
	}

	/**
	 * 0-1 背包：每个物品最多只能够装一次
	 * @param M
	 * @param wt
	 * @param val
	 * @return
	 */
	static int findMaxValue(int M, int[] wt, int[] val){
		int N = wt.length;
		int[][] dp = new int[N+1][M+1];
		Arrays.fill(dp[0], 0);
		for(int i=0; i<N; i++){
			dp[i][0] = 0;
		}

		for(int i=1; i<N+1; i++){
			for(int j=1; j<M+1; j++){
				if(j - wt[i-1] < 0){
					dp[i][j] = dp[i-1][j];
				}else {
					dp[i][j] = Math.max(dp[i - 1][j - wt[i - 1]] + val[i - 1], dp[i-1][j]);
				}
			}
		}
		return dp[N][M];
	}

	/**
	 * 完全背包：每个物品可以无限次数的装入
	 * @param M
	 * @param wt
	 * @param val
	 * @return
	 */
	static int findMaxValue2(int M, int[] wt, int[] val){
		int N = wt.length;
		int[][] dp = new int[N+1][M+1];
		Arrays.fill(dp[0], 0);
		for(int i=0; i<N; i++){
			dp[i][0] = 0;
		}

		for(int i=1; i<N+1; i++){
			for(int j=1; j<M+1; j++){
				if(j - wt[i-1] < 0){
					dp[i][j] = dp[i-1][j];
				}else {
					for(int k = 1 ; k < (j/wt[i-1]) + 1; k++) {
						dp[i][j] = Math.max(dp[i - 1][j - k * wt[i - 1]] + k * val[i - 1],
							   dp[i - 1][j]);
					}
				}
			}
		}
		return dp[N][M];
	}

	/**
	 * 多重背包：每个物品有装入次数的限制
	 * @param M
	 * @param wt
	 * @param val
	 * @return
	 */
	static int findMaxValue3(int M, int[] wt, int[] val){
		int N = wt.length;
		int[][] dp = new int[N+1][M+1];
		Arrays.fill(dp[0], 0);
		for(int i=0; i<N; i++){
			dp[i][0] = 0;
		}

		for(int i=1; i<N+1; i++){
			for(int j=1; j<M+1; j++){
				if(j - wt[i-1] < 0){
					dp[i][j] = dp[i-1][j];
				}else {
					int num = Math.min((j/wt[i-1]), i);
					for(int k = 1 ; k < num + 1; k++) {
						dp[i][j] = Math.max(dp[i - 1][j - k * wt[i - 1]] + k * val[i - 1],
							   dp[i - 1][j]);
					}
				}
			}
		}
		return dp[N][M];
	}
}
