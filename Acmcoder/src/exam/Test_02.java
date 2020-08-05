package exam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author wulling1024
 * @Create 2020-03-12  20:30
 * @Description
 */
public class Test_02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = {3, 1, 3, 2, 5};
		int tag = func(arr);
		for (int i = 0; i < arr.length; i++) {
			arr[i] = func2(arr[i], tag);
		}
		System.out.println(func(arr));
	}

	/**
	 * 找出数组中的众数
	 */
	static int func(int[] arr) {
		Map<Integer, Integer> maps = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (maps.containsKey(arr[i])) {
				maps.put(arr[i], maps.get(arr[i]) + 1);
				continue;
			}
			maps.put(arr[i], 1);
		}
		int max = 0;
		int target = 0;
		for (Integer key : maps.keySet()) {
			if (maps.get(key) > max) {
				max = maps.get(key);
				target = key;
			}
		}
		return target;
	}

	/**
	 * 两个数字异或为一个新数
	 */
	static int func2(int n, int m) {
		char[] char1 = Integer.toBinaryString(n).toCharArray();
		char[] char2 = Integer.toBinaryString(m).toCharArray();
		int tag = char1.length >= char2.length ? char2.length : char1.length;
		int result = 0;
		for (int i = 0; i < tag; i++) {
			if (char1[char1.length - 1 - i] == '1' || char2[char2.length - 1 - i] == '1') {
				result += Math.pow(2, i);
			}
		}
		return result;
	}

}
