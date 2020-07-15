import java.util.Arrays;

/**
 * @author wulling1024
 * @create 2019-03-19  21:06
 */
public class Solution {
	/**
	 * 根据双指针定位值大小的比较，进行遍历
	 *
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);  // 对数组进行排序
		int result;  // 输出结果
		result = nums[0] + nums[nums.length - 1] + nums[1];  // 设立初始值
		for (int i = 0; i < nums.length - 2; i++) {
			for (int p = i + 1, q = nums.length - 1; p < q; ) {
				//确定result
				if (Math.abs(nums[i] + nums[p] + nums[q] - target) < Math.abs(result - target)) {
					result = nums[i] + nums[p] + nums[q];
				}
				// 排序之后的双指针的定位
				if ((nums[i] + nums[p] + nums[q]) < target) {
					p++;
				} else if (nums[i] + nums[p] + nums[q] > target) {
					q--;
				} else {
					return target;
				}
			}
		}
		return result;
	}
}
