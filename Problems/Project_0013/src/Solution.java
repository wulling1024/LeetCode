import java.util.HashMap;
import java.util.Map;

/**
 * @author wulling1024
 * @create 2019-04-01  19:29
 */
public class Solution {
	/**
	 * 1、将符号与相应的数值进行对应 ：Map
	 * 2、读取一个字符，并于之后的一个字符根据value值进行比较：
	 * 如果大于，则直接加值，+1
	 * 如果小于，则换成第二个减第一个，+2
	 * 3、为空时，结束
	 *
	 * @param s
	 * @return
	 */
	public static int romanToInt(String s) {
		int result = 0;  // 结果输出
		Map<Character, Integer> markmap = new HashMap<>();  // 符号/值的关系建立
		markmap.put('I', 1);
		markmap.put('V', 5);
		markmap.put('X', 10);
		markmap.put('L', 50);
		markmap.put('C', 100);
		markmap.put('D', 500);
		markmap.put('M', 1000);

		if (s.isEmpty())
			return result;

		char[] str = s.toCharArray();  // 转化为字符数组
		int i;
		for (i = 0; i < str.length - 1; ) {  // 防止数组的越界
			if (markmap.get(str[i]) >= markmap.get(str[i + 1])) {  // 大于则直接加
				result += markmap.get(str[i]);
				i += 1;
			} else {
				result += markmap.get(str[i + 1]) - markmap.get(str[i]);  // 小于则先减后加，且需要跳一个位置
				i += 2;
			}
		}
		if (i == str.length - 1) {
			result += markmap.get(str[str.length - 1]); // 处理最后一个元素
		}
		return result;
	}
}
