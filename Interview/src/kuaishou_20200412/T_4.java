package kuaishou_20200412;

/**
 * @author wulling1024@163.com
 * @version 1.0
 * @since 2020-04-12  15:51:51
 */
public class T_4 {
	public static void main(String[] args) {

	}

	public int GetMaxStaffs (char[][] pos) {
		int M = pos.length;
		int N = pos[0].length;
		int[][] dp = new int[M][N];
		for(int i = 1; i<M; i++){
			if(pos[i][0] == '.' && pos[i-1][0] != '.'){
				dp[i][0] = 1;
			}
		}
		for(int i = 0; i<N; i++){
			if(pos[0][i] == '.'){
				dp[0][i] = 1;
			}
		}
		for(int i = 1; i<M; i++){
			for(int j = 1; j<N; j++){
				if(pos[i][j] == '.'){
					dp[i][j] = Math.max(Math.max(dp[i-1][j], dp[i+1][j]),
						   Math.max(dp[i][j-1], dp[i][j+1]))+1;
				}else{
					dp[i][j] = Math.max(Math.max(dp[i-1][j], dp[i+1][j]),
						   Math.max(dp[i][j-1], dp[i][j+1]));
				}
			}
		}
		return dp[M-1][N-1];
	}
}
