/**
 * @author wulling1024
 * @idea
 * @create 2019-03-15  9:59
 */
public class Solution {

	public static boolean isMatch(String s, String p) {
		boolean[] match = new boolean[s.length() + 1];

		match[s.length()] = true;
		for (int i = p.length() - 1; i >= 0; i--) {
			if (p.charAt(i) == '*') {
				for (int j = s.length() - 1; j >= 0; j--) {
					match[j] = match[j] || match[j + 1] && (p.charAt(i - 1) == '.' || p.charAt(i - 1) == s.charAt(j));
				}
				i--;
			} else {
				for (int j = 0; j < s.length(); j++) {
					match[j] = match[j + 1] && (p.charAt(i) == '.' || p.charAt(i) == s.charAt(j));
				}
				match[s.length()] = false;
			}
		}
		return match[0];
	}
}
