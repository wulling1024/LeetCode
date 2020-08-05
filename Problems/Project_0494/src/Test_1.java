import java.util.Scanner;

/**
 * @Author wulling1024
 * @Create 2020-03-11  16:57
 * @Description 动态规划
 */
public class Test_1 {
	static int findTargetSumWays(int[] nums, int S) {
		if ((nums.length - S) > 0 || (nums.length - S) % 2 != 0 || (nums.length + S) % 2 != 0) {
			return 0;
		}
		int[][] dp = new int[nums.length + 1][2001];
		dp[1][999] = 1;
		dp[1][1001] = 1;
		for (int i = 2; i < nums.length + 1; i++) {
			for (int j = -1000; j < 1000; j++) {
				if (dp[i - 1][j + 1000] > 0) {
//					dp[i][1000+j] = dp[i-1][1000+j-nums[i-1]] + dp[i-1][1000+j+nums[i-1]];
					dp[i][j + 1000 - nums[i]] += dp[i - 1][j + 1000];
					dp[i][j + 1000 + nums[i]] += dp[i - 1][j + 1000];
				}
			}
		}
		return dp[nums.length][1000 + S];
	}

	public static void main(String[] args) {
		int[] arr = {1, 1, 1, 1, 1};
		Scanner sc = new Scanner(System.in);
		while (true) {
			int nums = sc.nextInt();
			System.out.println(findTargetSumWays(arr, nums));
		}
	}
}