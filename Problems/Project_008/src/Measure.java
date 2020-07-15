/**
 * @author wulling1024
 * @idea 这个是提交答案里面的最佳答案，可以看看
 * @create 2019-03-09  16:25
 */
public class Measure {
	public int myAtoi(String str) {
		//去除极端情况的发生
		if (str == null || str.length() == 0) {
			return 0;
		}

		//去除前面的空格
		int start = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != ' ') {
				start = ++i;
				break;
			}
		}

		//取正负号
		long res = 0;
		boolean position = true;  //用于判定正负号
		if (str.charAt(start) == '-') {
			position = false;
			start++;
		} else if (str.charAt(start) == '+') {
			start++;
		}

		//提取数字
		for (int j = start; j < str.length(); j++) {
			//非数字开头
			if (str.charAt(j) < '0' || str.charAt(j) > '9') {
				break;
			}

			//计算得数值
			res = res * 10 + (str.charAt(j) - '0'); //字符之间的运算

			// 超越两个极端值
			if (!position && -res < Integer.MIN_VALUE)
				return Integer.MIN_VALUE;
			if (position && res > Integer.MAX_VALUE)
				return Integer.MAX_VALUE;
		}

		//加符号
		if (position == false)
			res = -res;

		return (int) res; //强制类型转换
	}
}
