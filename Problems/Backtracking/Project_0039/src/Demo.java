import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author wulling1024
 * @Create 2020-03-18  21:34
 * @Description
 */
class Solution {
	private static void callback(List<Integer> group, int[] candidates, int target, int index,
						    List<List<Integer>> res) {
		if (target == 0) {
			// 引用类型数据的传递
			res.add(new ArrayList<>(group));
			return;
		}
		for (int i = index; i < candidates.length; i++) {
			if (candidates[i] <= target) {
				group.add(candidates[i]);
				callback(group, candidates, target - candidates[i], i, res);
				group.remove(group.size() - 1);
			} else {
				return;
			}
		}
	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> group = new ArrayList<>();
		Arrays.sort(candidates);
		callback(group, candidates, target, 0, result);
		return result;
	}
}

public class Demo {
	public static void main(String[] args) {
		int[] candidates = {10, 1, 2, 7, 6, 1, 5};
		int target = 8;
		List<List<Integer>> result = Solution.combinationSum(candidates, target);
		for (List<Integer> e : result) {
			for (int p : e) {
				System.out.print(p + " ");
			}
			System.out.println("------");
		}
	}
}
