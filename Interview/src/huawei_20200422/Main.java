package huawei_20200422;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wulling1024@163.com
 * @version 1.0
 * @since 2020-04-22  19:31:31
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		char[] array = line.toCharArray();
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i< array.length; i++){
			if(array[i] >= 48 && array[i] <= 57){
				list.add(Integer.parseInt(array[i]+""));
			}
		}
		int[] result = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			result[i] = list.get(i);
		}
		Arrays.sort(result);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(result[i]);
		}
	}
}
