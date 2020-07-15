import java.util.Scanner;

/**
 * @author wulling1024
 * @idea
 * @create 2019-03-15  10:04
 */
public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String p = sc.next();
		Boolean result = Solution.isMatch(s, p);
		System.out.println(result);
	}
}
