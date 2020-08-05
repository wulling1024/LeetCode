package Basic;

import java.util.Scanner;

/**
 * @Author wulling1024
 * @Create 2020-03-10  14:52
 * @Description 基本算法 -> 股神
 */
public class Test20200310 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			System.out.println(fun(sc.nextInt()));
		}
	}

	static int fun(int date) {
		int tag = 0;
		int rem = 0;
		for (int i = 0; ; i++) {
			int temp = (i * i + i) / 2;
			if (temp > date) {
				tag = i - 1;
				rem = date - (tag * tag + tag) / 2;
				break;
			}
		}
		return 1 + (tag - 1) * (tag - 2) / 2 + rem;
	}
}
