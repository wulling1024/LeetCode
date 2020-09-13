package huawei;

/**
 * @author wulling1024@163.com
 * @version 1.0
 * @date 2020/09/09
 */
public class 完美排列 {
	public static void main(String[] args) {
		int[][] arr1 = new int[][]{{1, 2, 3}, {3, 2, 1}};
		int[][] arr2 = new int[][]{{1, 2, 1, 2, 3, 3}, {5, 4, 3, 2, 1, 1}};
		System.out.println(func(arr1, arr2) + 1);
	}

	static int func(int[][] model, int[][] target) {
		int a = model.length;
		int b = target[0].length;
		for (int i = 0; i < b; i++) {
			// 找出第一个相同的数据点
			if (model[0][0] == target[0][i]) {
				// 判断是否越界
				if (i + a <= b) {
					// 判断最后一个数据点是否相同
					if (model[0][a - 1] == target[0][i + a - 1]) {
						// 整串判断
						int j = 0;
						for (; j < a; j++) {
							if (model[0][j] == target[0][i + j]) {
								continue;
							} else {
								break;
							}
						}
						// 判断第二行数值是否相等
						if (j == a) {
							int k = 0;
							for (; k < a; k++) {
								if (model[1][k] == target[1][i + k]) {
									continue;
								} else {
									break;
								}
							}
							if (k == a) {
								return i;
							}
						} else {
							break;
						}
					}
				}
			}
		}
		return -1;
	}
}
