/**
 * @author wulling1024
 * @idea
 * @create 2019-03-15  11:57
 */
public class Solution {
	/**
	 * 将阿拉伯数字转化为罗马数字
	 * I：1  V：5  X：10  L：50  C：100  D：500  M：1000  B:5000
	 * 左边减 IV:4 右边加 VI:6
	 *
	 * @return
	 */
	char[] enums = new char[]{'I', 'V', 'X', 'L', 'C', 'D', 'M', 'B'};

	public String intToRoman(int num) {
		StringBuffer str = new StringBuffer();
		int calcnum = 1000;
		for (int i = 6; i >= 0; i -= 2) {
			convert(i, num / calcnum, str);
			num = num % calcnum;
			calcnum = calcnum / 10;
		}
		return str.toString();
	}

	//    转换函数
	public void convert(int data, int calcnum, StringBuffer str) {
		if (calcnum == 9) {
			str.append(enums[data]).append(enums[data + 2]);
		} else if (calcnum >= 5) {
			str.append(enums[data + 1]);
			while (calcnum-- > 5) {
				str.append(enums[data]);
			}
		} else if (calcnum == 4) {
			str.append(enums[data]).append(enums[data + 1]);
		} else {
			while (calcnum-- > 0) {
				str.append(enums[data]);
			}
		}
	}
}
