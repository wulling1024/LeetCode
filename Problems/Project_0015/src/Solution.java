import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wulling1024
 * @idea
 * @create 2019-03-16  9:57
 */
public class Solution {
//    数组已经有序

	/**
	 * 先稳定一个数，然后另外两个在数组两端协同并进
	 *
	 * @param nums
	 * @return
	 */
	public static List<List<Integer>> threeSum(int[] nums) {

		Arrays.sort(nums);
		List<Integer> arrays = new ArrayList<>();
		//   List<Integer> arrays1 = new ArrayList<>();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		// result.add(arrays);

		for (int i = 0; i < nums.length - 2; i++) {
			for (int p = i + 1, q = nums.length - 1; p < q; ) {
				//需要一个将arrays数组初始化的操作
				arrays.removeAll(arrays);  //清空判断是否有相似的
				if ((nums[i] + nums[p] + nums[q]) > 0)
					q--;
				else if ((nums[i] + nums[p] + nums[q]) < 0)
					p++;
				else {

					arrays.add(nums[i]);
					arrays.add(nums[p]);
					arrays.add(nums[q]);
					if (result.contains(arrays)) {
						p++;
						q--;
						continue;
					} else {
						result.add(Arrays.asList(nums[i], nums[p], nums[q]));
						p++;
						q--;
					}
				}
			}
		}
		return result;
	}

	//    冒泡排序
	public static int[] sortArray(int[] nums) {
		//循环嵌套
//        不断获取最小的一个值
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = nums.length - 1; j > i; j--) {
				int temp;
				if (nums[j] < nums[j - 1]) {
					temp = nums[j];
					nums[j] = nums[j - 1];
					nums[j - 1] = temp;
				}
			}
		}
		return nums;
	}
}
