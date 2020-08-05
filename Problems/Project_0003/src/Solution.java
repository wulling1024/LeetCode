/**
 * @author wulling1024
 * @idea 滑块浮动的形式 从[i,j) 到 (j`,j]
 * @create 2019-03-09  19:49
 */
public class Solution {
	public static int lengthOfLongestSubstring(String s) {

		// 除去极端情况的发生
		if (s == null || s.length() == 0) {
			return 0;
		} else {
			char[] chars = s.toCharArray();  //字符串转变为字符数组
			int start = 0, end = 0;  //字符串起使的位置与结束位置
			int len = 1;
			// 两层循环的嵌套
			for (int i = 0, j = 1; j < s.length(); j++) {
				for (int k = i; k < j; k++) {
					if (chars[k] == chars[j]) {
						i = k + 1; //变换i的位置
						break;
					}
				}
				if ((j - i + 1) > len) {
					len = j - i + 1;
					start = i;
					end = j;
				}
			}
			return len;
		}
	}
}
