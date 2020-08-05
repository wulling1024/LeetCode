import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wulling1024
 * @create 2019-03-18  20:06
 * 优势体现在出去重复的列表上-----根据的原理就是：已有序，如果相同必在一起
 */
public class Solution2 {
	public List<List<Integer>> threeSum(int[] nums) {
		//先对数组进行排序
		Arrays.sort(nums);
		//创建二维数组列表
		List<List<Integer>> arrays = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				break;
			} else {
				for (int p = i + 1, q = nums.length - 1; p < q; ) {
					if (nums[i] + nums[p] + nums[q] > 0) {
						while (p < q & nums[q] == nums[q - 1])
							q--;
						q--;
					} else if (nums[i] + nums[p] + nums[q] < 0) {
						while (p < q & nums[p] == nums[p + 1])
							p++;
						p++;
					} else {
						arrays.add(Arrays.asList(nums[i], nums[p], nums[q]));
						while (p < q & nums[q] == nums[q - 1])
							q--;
						q--;
						while (p < q & nums[p] == nums[p + 1])
							p++;
						p++;
					}
				}
			}
		}
		return arrays;
	}
}
