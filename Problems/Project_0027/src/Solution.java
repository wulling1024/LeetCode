import java.util.Arrays;

/**
 * @author wulling1024
 * @create 2019-03-25  15:49
 */
public class Solution {
	/**
	 * 要求：原地操作，空间复杂度 o(1) 去除所有指定的元素
	 * 1、数组进行排序
	 * 2、统计出个数之后，一次性前移
	 *
	 * @param nums
	 * @param val
	 * @return
	 */
	public static int removeElement(int[] nums, int val) {
		Arrays.sort(nums);  // 数组排序
		if (nums.length == 0)
			return 0;
		if (nums[nums.length - 1] != val) {
			int start = 0;
			int first = start;
			boolean state = false;
			for (int i = 0; i < nums.length; i++) {  // 未排除之后不出现相同元素的情况
				if (nums[i] == val && state == false) { // 找出第一个 =val 的值
					start = i;
					first = start;   // start 指向第一个val的位置
					state = true;
				}
				if (nums[i] != val && state == true) {  // 找出 val 之后第一个不等于 val 的值
					first = i;   // first 指向第一个不等于val的位置
					break; // 退出
				}
			}
			int temp = first - start;

			for (; first < nums.length; first++) {
				nums[first - temp] = nums[first];
			}

			return nums.length - temp;
		} else {
			int j;
			for (j = 0; j < nums.length; j++) {  //return 语句不能放在for循环里面，不然识别不到
				if (nums[j] == val) {
					break;
				}
			}
			return j;
		}
	}
}
/*
java.lang.ArrayIndexOutOfBoundsException: 4
  at line 18, Solution.removeElement
  at line 54, __DriverSolution__.__helper__
  at line 100, __Driver__.main
 */
