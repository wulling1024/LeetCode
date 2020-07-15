package kuaishou_20200412;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 有效括号的匹配
 * @author wulling1024@163.com
 * @version 1.0
 * @since 2020-04-12  15:51:51
 */
public class T_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
//		String str = "1*2+(3+3)))(((";
		int sum = 0;
		int left = 0;
		int right = 0;
		List<Character> lists = new ArrayList<>();
		char[] chars = str.toCharArray();
		for(char e : chars){
			if(e == ')' || e == '(') {
				lists.add(e);
			}
		}
		for(int i=0; i<lists.size();i++){
			if(lists.get(i) == '('){
				left++;
			}else{
				if(lists.get(i) == ')' && left > 0){
					sum++;
					left--;
				}else{
					right++;
				}
			}
		}
		System.out.println(sum + " " + left + " " + right);
	}
}
