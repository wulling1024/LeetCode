package ali_20200408;

import java.util.Scanner;

/**
 * 测试输入输出
 *
 * @author wulling1024@163.com
 * @version 1.0
 * @since 2020-04-08  15:19:19
 */
public class T_01 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入一个字符串(中间能加空格或符号)");
		String a = input.nextLine();
		System.out.println(a);
		System.out.println("请输入一个字符串(中间不能加空格或符号)");
		String b = input.next();
		System.out.println(b);
		System.out.println("请输入一个整数");
		int c;
		c = input.nextInt();
		System.out.println(c);
		System.out.println("请输入一个double类型的小数");
		double d = input.nextDouble();
		System.out.println(d);
		System.out.println("请输入一个float类型的小数");
		float f = input.nextFloat();
		System.out.println(f);
		String sre2 = input.nextLine();
		System.out.println(sre2);

	}
}
