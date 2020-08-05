import java.util.Random;

/**
 * @Author wulling1024
 * @Create 2020-03-18  13:13
 * @Description
 */
class Solution {
	public static int[][] merge(int[][] intervals) {
		if (intervals.length > 1) {
			sort(intervals, 0, intervals.length - 1);
			int[][] temp = new int[intervals.length][2];
			int tag = 0;
			temp[tag] = intervals[0];
			for (int i = 1; i < intervals.length; i++) {
				if (temp[tag][1] >= intervals[i][0] && temp[tag][1] < intervals[i][1]) {
					temp[tag] = new int[]{temp[tag][0], intervals[i][1]};
				} else if (temp[tag][1] >= intervals[i][1]) {
					continue;
				} else {
					temp[++tag] = intervals[i];
				}
			}
			int[][] result = new int[tag + 1][2];
			for (int i = 0; i <= tag; i++) {
				result[i] = temp[i];
			}
			return result;
		}
		return intervals;
	}

	// 根据arr[i][0] 进行快速排序
	private static void sort(int[][] arr, int L, int R) {
		if (L < R) {
			swap(arr, new Random().nextInt(R - L + 1) + L, R);
			int[] tag = partition(arr, L, R);
			sort(arr, L, tag[0]);
			sort(arr, tag[1], R);
		}
	}

	// 元素分区
	private static int[] partition(int[][] arr, int L, int R) {
		int basic = arr[R][0];
		int less = L - 1;
		int more = R + 1;
		while (L < more) {
			if (arr[L][0] < basic) {
				swap(arr, ++less, L++);
			} else if (arr[L][0] > basic) {
				swap(arr, --more, L);
			} else {
				L++;
			}
		}
		return new int[]{less, more};
	}

	//元素交换
	private static void swap(int[][] arr, int a, int b) {
		int[] temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}

public class Demo {
	public static void main(String[] args) {
		int[][] arr = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
		int[][] arr2 = {{1, 4}, {4, 5}};
		int[][] arr3 = {{1, 4}, {5, 6}};
		int[][] arr4 = {{1, 4}, {0, 2}, {3, 5}};
		int[][] result = Solution.merge(arr4);
		for (int i = 0; i < result.length; i++) {
			System.out.println("[" + result[i][0] + "," + result[i][1] + "]");
		}
		System.out.println(arr.length);
	}
}
