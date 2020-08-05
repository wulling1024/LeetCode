package Basic;

import java.util.Scanner;

/**
 * @Author wulling1024
 * @Create 2020-03-10  21:08
 * @Description 基本算法 -> 约德尔测试
 */
public class Test20200310_3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String test = sc.nextLine();
		String target = sc.nextLine();
		char[] charArray = test.toCharArray();
		char[] charArray1 = target.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
//			if(charArray[i] >= 48 && charArray[i] <= 57 || charArray[i] >= 97 && charArray[i] <= 122 || charArray[i] >= 65 && charArray[i] <= 90){
//				charArray[i] = '1';
//				continue;
//			}
			// 通过工具类来判断字符是数字还是字母 -> Character
			if (Character.isDigit(charArray[i]) || Character.isLetter(charArray[i])) {
				charArray[i] = '1';
				continue;
			}
			charArray[i] = '0';
		}
		System.out.println(String.format("%.2f", func(charArray, charArray1)) + "%");
	}

	static double func(char[] test, char[] target) {
		double count = 0;
		for (int i = 0; i < test.length; i++) {
			if (test[i] == target[i]) {
				count += 1;
			}
		}
		return (count / test.length) * 100;
	}
}
