import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author wulling1024
 * @create 2019-03-18  17:05
 */
public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] nums = new int[5];
		for (int i = 0; i < 5; i++) {
			nums[i] = sc.nextInt();
		}

		List<Integer> arrays = new ArrayList<>();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		result.add(arrays);

		//    nums = Solution.sortArray(nums);

		result = Solution.threeSum(nums);
		System.out.println(result);
	}
}
