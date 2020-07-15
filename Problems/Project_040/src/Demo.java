import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

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
			if (!res.contains(group)) {
				res.add(new ArrayList<>(group));
			}
			return;
		}
		for (int i = index; i < candidates.length; i++) {
			if (candidates[i] <= target) {
				group.add(candidates[i]);
				callback(group, /*segment(candidates, i)*/candidates, target - candidates[i], i + 1,
					   res);
				group.remove(group.size() - 1);
			} else {
				return;
			}
		}
	}

	private static int[] segment(int[] arr, int target) {
		int[] result = new int[arr.length - 1];
		int i = 0;
		int j = 0;
		while (i < arr.length - 1) {
			if (j != target) {
				result[i++] = arr[j++];
				continue;
			}
			j++;
		}
		return result;
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

class Best {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> res = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		dfs(candidates, res, stack, target, 0);
		return res;
	}

	public void dfs(int[] candidates, List<List<Integer>> res, Stack<Integer> stack, int target, int begin) {
		if (target == 0) {
			res.add(new ArrayList<>(stack));
			return;
		}
		for (int i = begin; i < candidates.length; i++) {
			if (candidates[i] > target) {
				break;
			}
			if (i > begin && candidates[i - 1] == candidates[i]) {
				continue;
			}
			stack.push(candidates[i]);
			dfs(candidates, res, stack, target - candidates[i], i + 1);
			stack.pop();
		}
	}
}
