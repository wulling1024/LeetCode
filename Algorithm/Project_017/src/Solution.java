import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wulling1024
 * @create 2019-04-01  9:53
 */
class SolutionDemo {
	/**
	 * 映射关系，最好的处理方式就是map
	 * 1、先将字符串转化为单个字符，然后一一匹配，得出相应的字符串
	 * 2、然后将所得的字符串的字符进行随机的组合
	 * @param digits
	 * @return
	 */
	public List<String> letterCombinations(String digits) {
//		结果输出
		List<String> result = new ArrayList<>();
//		将键盘对应的映射关系进行存储
		Map<Character,String> markmap = new HashMap<>();
//		markmap.put('1',"");
		markmap.put('2',"abc");
		markmap.put('3',"def");
		markmap.put('4',"ghi");
		markmap.put('5',"jkl");
		markmap.put('6',"mno");
		markmap.put('7',"pqrs");
		markmap.put('8',"tuv");
		markmap.put('9',"wxyz");
// 		字符串转字符数组
		char[] str = digits.toCharArray();
		int len = digits.length();
//		将数字对应的字符串进行存储
		List<String> list = new ArrayList<>();
		for(int i = 0 ; i < str.length ; i++){
			list.add(markmap.get(str[i]));
		}

//		排列组合的层级是不定的
		for(int i = 0 ; i < list.get(0).length() ; i++){
			for(int j = 0 ; j < list.get(1).length() ; j++){
				result.add(String.valueOf(list.get(0).toCharArray()[i]) + String.valueOf(list.get(1).toCharArray()[j]));
			}
		}
		return result;
	}
}

public class Solution{
	public static void main(String[] args) {
		String str = "23";
		SolutionDemo demo = new SolutionDemo();
		System.out.println(demo.letterCombinations(str));
	}
}
