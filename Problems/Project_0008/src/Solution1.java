/**
 * @idea
 * @wauthor wulling1024
 * @create 2019-01-09  16:18
 */
public class Solution1 {
	public int myAtoi(String str) {
		int i = 0, ans = 0, len = str.length();
		int sign = 1; //用于定义符号（‘+’、‘-’）

		//判断字符串前面的空格符
		while (i < len && str.charAt(i) == ' ')
			++i;  //直接判断

		//判断得出该数的正负性，并且显示出'+' or '-'
		if (i < len && (str.charAt(i) == '-' || str.charAt(i) == '+')) {
			sign = str.charAt(i++) == '+' ? 1 : -1;
		}

		//
		for (; i < len; ++i) {
			int tmp = str.charAt(i) - '0';
			if (tmp < 0 || tmp > 9) break;
			if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && (sign == 1 && tmp > 7 || sign == -1 && tmp > 8))) {
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			} else {
				ans = ans * 10 + tmp;
			}
		}
		return sign * ans;
	}
}
