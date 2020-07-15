import java.util.List;

/**
 * @author wulling1024
 * @create 2019-03-27  19:58
 */
public class Test {
	public static void main(String[] args) {
		String s = "a";
		String[] words = {"a"};
		List<Integer> result = Solution2.findSubstring(s, words);
		System.out.println(result);
	}
}
