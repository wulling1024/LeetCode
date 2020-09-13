/**
 * @author wulling1024@163.com
 * @version 1.0
 * @date 2020/09/10
 */
public class 零钱兑换2 {
	public static void main(String[] args) {
		int[] arr = new int[]{1, 2, 5};
		int amount = 5;
		System.out.println(solve(amount, arr));
	}

	static int solve(int amount, int[] coins) {
		int[] result = new int[amount+1];

		for (int i = 1; i< result.length; i++){
			for(int j = 0; j< coins.length; j++){
				if(i == coins[j]){
					result[i] += 1;
				}
				if(i - coins[j] > 0) {
					result[i] += result[i-coins[j]];
				}
			}
		}
		return result[amount];
	}
}
