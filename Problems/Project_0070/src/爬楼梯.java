/**
 * @author wulling1024@163.com
 * @version 1.0
 * @date 2020/09/10
 */
public class 爬楼梯 {
	public static void main(String[] args) {
		int[] arr = new int[]{1, 2};
		int amount = 3;
		System.out.println(solution(arr, amount));
	}

	static int solution(int[] arr, int amount) {
		int[] result = new int[amount+1];
		result[1] = 1;
		result[2] = 2;
		for (int i = 3; i< result.length; i++) {
			for (int j = 0; j< arr.length; j++) {
				if (i-arr[j] > 0) {
					result[i] += result[i - arr[j]];
				}
			}
		}
		return result[amount];
	}

	/**
	 * 社会性改造
	 * @param n
	 * @return
	 */
	public int climbStairs(int n) {
		if (n <= 0){
			return 0;
		}
		int[] result = new int[n+1];
		result[1] = 1;
		if (n == 2) {
			return 2;
		}else if (n > 2) {
			result[2] = 2;
			for (int i = 3; i < result.length; i++) {
				if (i - 1 > 0) {
					result[i] += result[i - 1];
				}
				if (i - 2 > 0) {
					result[i] += result[i - 2];
				}
			}
		}
		return result[n];
	}
}
