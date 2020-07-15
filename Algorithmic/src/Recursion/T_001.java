package Recursion;

/**
 * @Author wulling1024
 * @Create 2020-03-11  15:23
 * @Description 实现斐波那契数列
 */
public class T_001 {
	static int[] arr = new int[100];

	static int func(int n) {
		if (n == 1 || n == 2) {
			return 1;
		} else {
			return func(n - 1) + func(n - 2);
		}
	}

	public static void main(String[] args) {
		func(5);
		System.out.println(func(6));
	}
}
