/**
 * @Author wulling1024
 * @Create 2020-03-19  16:03
 * @Description
 */
class Solution {
	public int maxSubArray(int[] nums) {
		if (nums.length > 1) {
			int[] dp = new int[nums.length];
			dp[0] = nums[0];
			for (int i = 1; i < nums.length; i++) {
				if (nums[i - 1] >= 0)
					dp[i] = dp[i - 1] + nums[i];

			}
			return dp[nums.length - 1];
		} else {
			return nums[0];
		}
	}
}

public class Demo {
	public static void main(String[] args) {

	}
}
