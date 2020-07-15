import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author wulling1024
 * @Create 2020-01-11  16:51
 * @Description
 */
class SolutionDemo {

	public static boolean isValid(String s) {
		Map<String, String> map = new HashMap<>();
		map.put(")", "(");
		map.put("]", "[");
		map.put("}", "{");
//		将整个输入集进行包裹
		String str = "(" + s + ")";
		Stack<String> stack = new Stack<>();
		stack.push("(");
		for (int i = 1; i < str.length(); i++) {
			String temp = map.get(String.valueOf(str.charAt(i)));
			if (temp == null) {
				stack.push(String.valueOf(str.charAt(i)));
				continue;
			}
			if (!stack.empty() && temp.equals(stack.peek())) {
				stack.pop();
				if (i == str.length() - 1) {
					break;
				}
				continue;
			}
			stack.push(String.valueOf(str.charAt(i)));
		}
		if (stack.empty()) {
			return true;
		}
		return false;
	}
}

public class Solution {

	public static void main(String[] args) {
		String str = "[])";
		System.out.println(SolutionDemo.isValid(str));
	}
}
