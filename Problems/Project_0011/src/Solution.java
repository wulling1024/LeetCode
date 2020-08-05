/**
 * @author wulling1024
 * @idea
 * @create 2019-03-15  10:53
 */
public class Solution {
	/**
	 * 容器的长：j-i
	 * 容器的高：height[j]、height[i]比较选择最小的
	 *
	 * @param height
	 * @return
	 */

	public int maxArea(int[] height) {
		//面积
		int maxscale = 0;
//        循环嵌套比较
		for (int i = 0; i < height.length - 1; i++) {
			for (int j = i + 1; j < height.length; j++) {
				int temp;
//                高度比较，获取最矮的
				if (height[i] > height[j]) {
					temp = height[j];
				} else {
					temp = height[i];
				}
				maxscale = maxscale > (j - i) * temp ? maxscale : (j - i) * temp;
			}
		}
		return maxscale;
	}
}
