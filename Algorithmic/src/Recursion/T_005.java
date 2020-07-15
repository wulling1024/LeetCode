package Recursion;

/**
 * 查询最坏情况的最少次数
 * @author wulling1024@163.com
 * @version 1.0
 * @since 2020-04-12  10:04:04
 */
public class T_005 {
	public static void main(String[] args) {
		System.out.println(findBestWorst(3, 100));
	}

	static int findBestWorst(int K, int P){
		int[][] dp = new int[K+1][P+1];
		for(int i=1; i<K+1; i++){
			dp[i][1] = 1;
		}
		for(int i=1; i<P+1; i++){
			if(K == 1) {
				dp[1][i] = i;
			}else{
				for(int j=2; j<K+1; j++){
					for(int k=1; k<P+1; k++){
						dp[j][k] =
							   Math.min(dp[1][k], Math.max(dp[j][P-k], dp[j-1][k-1]) + 1);
					}
				}
			}
		}
		return dp[K][P];
	}
}
