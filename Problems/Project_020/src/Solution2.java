/**
 * @Author wulling1024
 * @Create 2020-01-11  19:40
 * @Description 最快解决方案
 */
class Solution2Demo {
	public boolean isValid(String s) {
		if (s.length() % 2 == 1) {
			return false;
		}
		char[] chars = s.toCharArray();
		char[] cs = new char[s.length() / 2 + 1];
		int j = 0;
		char c1, c2;
		for (int i = 0; i < chars.length && j < cs.length; i++) {
			c1 = chars[i];
			if (c1 == '(' || c1 == '{' || c1 == '[') {
				cs[j] = c1;
				j++;
				continue;
			}
			if (j == 0) {
				return false;
			}
			c2 = cs[j - 1];
			j--;
			if (c1 != c2 + 1 && c1 != c2 + 2) {
				return false;
			}
		}
		return j == 0;
	}
}

public class Solution2 {
}
