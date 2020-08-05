import java.util.Scanner;

/**
 * @author wulling1024
 * @create 2019-03-18  17:05
 */
public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] nums = new int[8];
		for (int i = 0; i < 8; i++) {
			nums[i] = sc.nextInt();
		}
		int target = sc.nextInt();
		System.out.println(Solution.fourSum(nums, target));

	}
}
