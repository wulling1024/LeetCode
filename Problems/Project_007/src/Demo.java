import java.util.Scanner;

/**
 * @idea 实现整数的反转   当然也包括负数的
 * 例如 -123  →   -321
 * @wauthor wulling1024
 * @create 2018-12-29  20:42
 */
class Function {
	static void funtion(int a) {
		//对于负数类型，先进行整数化，然后转化为负数
		if (a < 0) {
			int temp = -a;
			int g = 0;
			int A[] = new int[10];
			for (int j = 0; temp > 0; j++) {
				A[j] = temp % 10;
				temp = temp / 10;
				g++;
			}
			long result = 0;
			for (int j = 0; g > 0; ) {
				result += A[j++] * Math.pow(10, --g);
			}
			result = -result;
			System.out.println(result);
		} else if (a > 0) {
			int temp1 = a;
			int k = 0;
			int B[] = new int[10];
			for (int j = 0; temp1 > 0; j++) {
				B[j] = temp1 % 10;
				temp1 = temp1 / 10;
				//  System.out.println(temp1);
				k++;
			}
			// System.out.println(k);
			long result = 0;
			for (int j = 0; k > 0; ) {
				result += B[j++] * Math.pow(10, --k);
			}
			System.out.println("转换后结果为" + result);
		} else {
			System.out.println(a);
		}
	}
}

public class Demo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入你想反转的数：");
		int a = sc.nextInt();
		Function.funtion(a);
	}
}

