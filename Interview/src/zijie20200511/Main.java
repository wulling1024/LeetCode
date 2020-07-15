package zijie20200511;

import java.util.Scanner;

/**
 * @author wulling1024@163.com
 * @version 1.0
 * @date 2020/05/11
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nums = sc.nextInt();
		// 实际输入
		String[][] input = new String[nums][2];

		// 使用二维数组来存储结果值 0:原结果值，1:字符追加，2:字符删除，3:输出值，4:回滚结果
		String[][] result = new String[nums+1][6];
		int tag = 1;
		while(tag < nums){
			switch (input[tag][0]){
				case "1":
					result[tag][0] = result[tag-1][0];
					result[tag][1] = result[tag][0] + input[tag-1][1];
					result[tag][5] = result[tag][1];
					break;
				case "2":
					char[] chars = input[tag - 1][1].toCharArray();
					int length = chars[0];
					result[tag][0] = result[tag-1][5];
					result[tag][2] = result[tag][0].substring(0,
						   result[tag][0].length()-length-1);
					result[tag][5] = result[tag][2];
					break;
				case "3":
					result[tag][3] = result[tag-1][5];
					result[tag][5] = result[tag-1][5];
					System.out.println(result[tag][5]);
					break;
				case "4":

			}
		}
	}

}
