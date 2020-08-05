import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author wulling1024
 * @create 2019-03-30  15:38
 */
public class Solution2 {

	public static List<Integer> findSubstring(String s, String[] words) {
		List<Integer> result = new ArrayList<>();
		if (s.length() == 0 || words.length == 0 || s.length() < words[0].length())  // 极端情况的排除
			return result;

		List<List<Integer>> location = new ArrayList<>(); // 用于存储 word 的位置信息
		for (int i = 0; i < words.length; i++)  // 遍历words数组
			location.add(Solution2.findLocation(s, words[i]));

		SortedSet<Integer> sortLocation = new TreeSet<>();  // 获取各位置信息的排序树
		for (int i = 0; i < words.length; i++) {   // 遍历二维列表
			for (int j = 0; j < location.get(i).size(); j++) {
				sortLocation.add(location.get(i).get(j));
			}
		}

		char[] array = s.toCharArray();
		int len = words[0].length();
		int i, j;
		for (i = ((TreeSet<Integer>) sortLocation).pollFirst(); i < s.length(); ) {
			List<String> wordlist = new ArrayList<>();  // 每次初始化这个判定条件
			for (int p = 0; p < words.length; p++) {
				wordlist.add(words[p]);
			}

			for (j = 0; j < words.length; j++) {
				char[] temp = new char[len];
				for (int k = 0; k < len; k++) {
					try {
						temp[k] = array[i + j * len + k];
					} catch (ArrayIndexOutOfBoundsException e) {
						System.out.println("处理越界的异常");
						break;
					}
				}
				String str = new String(temp);  // 转换为字符串
				boolean status = false;
				for (int p = 0; p < words.length; p++) {
//                    if(words[p].equals(str)){   // 重复出现的情况，没有排除。比如 foo  foo  出现两次
//                        status = true;
//                        break;
//                    }
					if (wordlist.contains(str)) {   // 出现重复的也排除了
						status = true;
						wordlist.remove(str);
						break;
					}
				}
				if (status == true)
					continue;
				else
					break;
			}
			if (j == words.length)
				result.add(i);
			if (!sortLocation.isEmpty())
				i = ((TreeSet<Integer>) sortLocation).pollFirst();
			else
				break;
		}

		return result;
	}

	/**
	 * 功能：找出 word 能在 words 存在的位置信息
	 *
	 * @param s
	 * @param word
	 * @return
	 */
	public static List<Integer> findLocation(String s, String word) {
		List<Integer> result = new ArrayList<>();  // 结果输出
		char[] array1 = s.toCharArray();  //字符串转化为字符数组
		char[] array2 = word.toCharArray();
		int i, j;
		for (i = 0; i < array1.length - array2.length + 1; i++) {   // 遍历母串
			j = 0;  // 子串结束点
			for (; j < array2.length; j++) {  //遍历子串
				if (array1[i + j] == array2[j]) {  // 相同点
					continue;
				} else {
					break;
				}
			}
			if (j == array2.length)
				result.add(i);
		}
		return result;
	}
}



