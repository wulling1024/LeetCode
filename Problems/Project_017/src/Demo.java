import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wulling1024
 * @create 2019-04-01  9:53
 */
class Solution {
	//将键盘对应的映射关系进行存储
	static Map<String, String> markmap = new HashMap<String, String>() {{
		put("0", "");
		put("1", "");
		put("2", "abc");
		put("3", "def");
		put("4", "ghi");
		put("5", "jkl");
		put("6", "mno");
		put("7", "pqrs");
		put("8", "tuv");
		put("9", "wxyz");
	}};
	//结果输出
	static List<String> result = new ArrayList<>();

	public static List<String> letterCombinations(String digits) {
		if (digits.length() != 0) {
			callback("", digits);
		}
		return result;
	}

	//回溯思想：上一轮的结果 + 下一轮的参数
	private static void callback(String combination, String next) {
		if (next.length() == 0) {
			result.add(combination);
		} else {
			String digit = next.substring(0, 1);
			String letters = markmap.get(digit);
			for (int i = 0; i < letters.length(); i++) {
				String letter = letters.substring(i, i + 1);
				callback(combination + letter, next.substring(1));
			}
		}

	}
}

public class Demo {
	public static void main(String[] args) {
		String str = "23";
		List<String> result = Solution.letterCombinations(str);
		for (String e : result) {
			System.out.println(e);
		}
	}
}
