/**
 * @author wulling1024
 * @create 2019-03-31  20:40
 */
public class Solution {
	/**
	 * 将第一个字符串作为公共子串与第二个字符串相比较，找出公共字符所组成的串，再将此串与之后的字符串做对比
	 *
	 * @param strs
	 * @return
	 */
	public static String longestCommonPrefix(String[] strs) {
		String result = "";  //为空时的默认输出
		if (strs.length == 0)
			return result;
		if (strs.length == 1) {
			return strs[0];
		}
		char[] array = strs[0].toCharArray();  // 作为第一个默认子串
		for (int i = 1; i < strs.length; i++) {
			char[] arr = strs[i].toCharArray();
			int k = 0;
			for (int j = 0; j < Math.min(array.length, arr.length); j++) {
				if (arr[j] == array[j]) {  // 字符遍历比较
					array[k++] = arr[j];
				} else {
					break;
				}
			}
			String string = new String(array);   // 字符数组转换为字符串的方式
			String str = string.substring(0, k);  // 从母串中挑选出固定的子串
			array = str.toCharArray();
		}
		result = new String(array);
		return result;
	}
}
