import java.util.ArrayList;
import java.util.List;

/**
 * @idea 官方方案：按行排序
 * @wauthor wulling1024
 * @create 2018-12-04  18:30
 */
public class Solution {
	public String convert(String s, int numRows) {
		//极端个例情况的排除
		if (numRows == 1)
			return s;

		//行数组的建立
		List<StringBuilder> str = new ArrayList<>();
		for (int i = 0; i < Math.min(numRows, s.length()); i++)
			str.add(new StringBuilder());

		int temp = 0;
		boolean goingdown = false;
		for (char c : s.toCharArray()) {
			str.get(temp).append(c);
			if (temp == 0 || temp == numRows - 1)  //到达两个端点的判定点
				goingdown = !goingdown;
			temp += goingdown ? 1 : -1;
		}
//      进行各行字符串的拼接
		StringBuilder ret = new StringBuilder();
		for (StringBuilder row : str)
			ret.append(row);

		return ret.toString();
	}
}
