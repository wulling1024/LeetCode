/**
 * @author wulling1024@163.com
 * @version 1.0
 * @date 2020/09/09
 */
public class 零钱兑换 {
	public static void main(String[] args) {
		int[] arr = new int[]{1, 2, 5};
		int m = 11;
		System.out.println(coinChange(arr, m));
	}

	static int coinChange(int[] coins, int amount) {
		int[] result = new int[amount+1];
		result[0] = 0;

		for (int i = 1; i < amount+1; i++) {
			result[i] = Integer.MAX_VALUE-1;
			for (int j = 0; j < coins.length; j++) {
				if (i >= coins[j]) {
					result[i] = Math.min(result[i], result[i - coins[j]]);
				}
			}
			result[i]++;
		}
		if (result[amount] == Integer.MAX_VALUE) {
			return -1;
		}
		return result[amount];
	}
}
