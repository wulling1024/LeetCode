import java.util.Scanner;

/**
 * @idea 测试用例
 * @wauthor wulling1024
 * @create 2018-12-04  18:48
 */
public class test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println("------------------");
		int num = sc.nextInt();
		Solution solution = new Solution();
		String newString = solution.convert(s, num);
		System.out.println("旧的序列为：" + s.toString());
		System.out.println("新的序列为：" + newString.toString());
	}
}
