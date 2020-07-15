package Sort;

/**
 * @Author wulling1024
 * @Create 2020-03-04  20:27
 * @Description 交换排序 -> 冒泡排序
 * 思想：
 */
class BubbleSort {
	public static void sort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}
}

public class Change2 {
	public static void main(String[] args) {
		int[] arr = {5, 7, 2, 4, 6, 8, 5};
		BubbleSort.sort(arr);
		for (int i : arr) {
			System.out.print(i + ", ");
		}
	}
}