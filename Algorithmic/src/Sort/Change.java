package Sort;

import java.util.Random;

/**
 * @Author wulling1024
 * @Create 2020-03-04  20:16
 * @Description 交换排序 -> 快速排序（分治思想）
 */
class QuickSort {
	public static void sort(int[] arr, int L, int R) {
		if (L < R) {
			//以任意一个元素作为基准值
			swap(arr, new Random().nextInt(R - L + 1) + L, R);
			int[] temp = partition(arr, L, R);
			sort(arr, L, temp[0]);
			sort(arr, temp[1], R);
		}
	}

	// 根据基准进行分区处理
	private static int[] partition(int[] arr, int L, int R) {
		int basic = arr[R];
		int less = L - 1;
		int more = R + 1;
		while (L < more) {
			if (arr[L] < basic) {
				swap(arr, ++less, L++);
			} else if (arr[L] > basic) {
				swap(arr, --more, L);
			} else {
				L++;
			}
		}
		return new int[]{less, more};
	}

	// 数组之间交换元素
	private static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}

public class Change {
	public static void main(String[] args) {
		int[] arr = {5, 7, 2, 4, 6, 8, 5};
		QuickSort.sort(arr, 0, arr.length - 1);
		for (int i : arr) {
			System.out.print(i + ", ");
		}
	}
}
