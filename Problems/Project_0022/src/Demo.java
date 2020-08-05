import java.util.ArrayList;
import java.util.List;

/**
 * @Author wulling1024
 * @Create 2020-01-11  19:54
 * @Description
 */
class Solution {
	static List<String> result = new ArrayList<>();

	private static void callback(String str, int open, int close, int n) {
		if (str.length() == n * 2) {
			result.add(str);
		}
		if (open < n) {
			callback(str + "(", open + 1, close, n);
		}
		if (close < open) {
			callback(str + ")", open, close + 1, n);
		}
	}

	public static List<String> generateParenthesis(int n) {
		callback("", 0, 0, n);
		return result;
	}
}

public class Demo {
	public static void main(String[] args) {
		List<String> result = Solution.generateParenthesis(3);
		for (String e : result) {
			System.out.println(e);
		}
	}
}
