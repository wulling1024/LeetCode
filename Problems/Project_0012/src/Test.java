import java.util.Scanner;

/**
 * @author wulling1024
 * @idea
 * @create 2019-03-15  15:50
 */
public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
//        Finally fin = new Finally();
//        String str = fin.intToRoman(num);
//        System.out.println(str.toString());
		Solution solution = new Solution();
		String str = solution.intToRoman(num);
		System.out.println(str.toString());
	}

}
