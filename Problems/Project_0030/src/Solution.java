import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author wulling1024
 * @create 2019-03-27  19:15
 * 思想：
 * 1、先找出所有子串在父串中的位置信息
 * 2、根据对应的位置信息进行判断是不是在一起
 * 3、这种方式可以无视words中的单词的长度，是一种拓展
 */
public class Solution {
	public static List<Integer> findSubstring(String s, String[] words) {
		List<Integer> result = new ArrayList<>();  // 结果输出值

		List<List<Integer>> nums = new ArrayList<>();
		for (int i = 0; i < words.length; i++) {  // 存储每个 word 在母串中出现的位置的数组列表
			List<Integer> list = location(s, words[i]);
			nums.add(list);
		}
//        说明并不是每个word都出现了
		if (nums.size() != words.length)
			result = null;
		// 将列表转换为数组
		// 注意：Integer 与 int 是不等价的
//        Object[] obj = nums.toArray();
//        int[][] arrays = new int[nums.size()][];
//        for(int i =0;i<nums.size();i++)
//            arrays[i] = (int[])obj[i];
		Integer[][] arrays = new Integer[nums.size()][];  // 二维数组定义时，必须要指定行数（即第一个变量）
		for (int i = 0; i < nums.size(); i++) {   // 将列表转换为二维数组
			arrays[i] = nums.get(i).toArray(new Integer[nums.get(i).size()]);
		}
//        System.out.println(arrays);
//
//        map存储 ：key 出现的位置   value 对应word的长度
		Map<Integer, Integer> treeMap = new TreeMap<>();
		for (int i = 0; i < nums.size(); i++) {
			for (int j = 0; j < arrays[i].length; j++) {
				treeMap.put(arrays[i][j], words[i].length());
			}
		}

		System.out.println(treeMap);
		return null;
	}

	/**
	 * 求解字符串str在母串s中出现的位置信息，利用动态数组进行存储
	 *
	 * @param s
	 * @param str
	 * @return
	 */
	public static List<Integer> location(String s, String str) {
		List<Integer> list = new ArrayList<>(); // 结果输出变量
		char[] array1 = s.toCharArray();  // 将字符串转换为对应的字符数组
		char[] array2 = str.toCharArray();
		int i, j;
		for (i = 0; i < array1.length - array2.length; i++) {  // 母串遍历
			j = 0;
			for (; j < array2.length; j++) {  //子串匹配遍历
				if (array1[i + j] == array2[j])
					continue;
				else
					break;
			}
			if (j == array2.length) {  // 匹配成功判断
				list.add(i);
			}
		}
		return list;
	}
}