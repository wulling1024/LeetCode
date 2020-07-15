import java.util.LinkedList;

/**
 * @Author wulling1024
 * @Create 2020-03-18  14:42
 * @Description
 */
class Solution {
	public static int[][] insert(int[][] intervals, int[] newInterval) {
		//输出结果
		LinkedList<int[]> result = new LinkedList<>();
		int tag = 0;
		//直接输出[0]比newInterval小的元素
		while (tag < intervals.length && intervals[tag][0] < newInterval[0]) {
			result.add(intervals[tag++]);
		}
		//处理newInterval的插入
		int[] interval = new int[2];
		if (result.isEmpty() || result.getLast()[1] < newInterval[0]) {
			result.add(newInterval);
		} else {
			interval = result.removeLast();
			interval[1] = Math.max(interval[1], newInterval[1]);
			result.add(interval);
		}
		//处理可能剩余的intervals元素
		while (tag < intervals.length) {
			interval = intervals[tag++];
			int start = interval[0];
			int end = interval[1];
			if (result.getLast()[1] < start) {
				result.add(interval);
			} else {
				interval = result.removeLast();
				interval[1] = Math.max(interval[1], end);
				result.add(interval);
			}
		}
		return result.toArray(new int[result.size()][2]);
	}
}

public class Demo {
	public static void main(String[] args) {
		int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
		int[] newInterval = {4, 8};
		long start = System.currentTimeMillis();
		int[][] result = Solution.insert(intervals, newInterval);
		for (int[] e : result) {
			System.out.println("[" + e[0] + "," + e[1] + "]");
		}
		System.out.println(System.currentTimeMillis() - start);
		start = System.currentTimeMillis();
		int[][] result2 = Best.insert(intervals, newInterval);
		for (int[] e : result2) {
			System.out.println("[" + e[0] + "," + e[1] + "]");
		}
		System.out.println(System.currentTimeMillis() - start);
	}
}

class Best {
	public static int[][] insert(int[][] intervals, int[] newInterval) {
		int len = intervals.length;
		// 左侧最靠近新区间并且无重叠的区间下标
		int left = -1;
		while (left + 1 < len && intervals[left + 1][1] < newInterval[0]) {
			left++;
		}
		// 右侧最靠近新区间并且无重叠的区间下标
		int right = len;
		while (right - 1 >= 0 && intervals[right - 1][0] > newInterval[1]) {
			right--;
		}
		// 新区间下标
		int index = left + 1;
		int[] merged;
		if (left + 1 == right) {
			merged = newInterval;
		} else {
			merged = new int[]{Math.min(intervals[left + 1][0], newInterval[0]), Math.max(intervals[right - 1][1], newInterval[1])};
		}
		int[][] ans = new int[left + 1 + len - right + 1][];
		System.arraycopy(intervals, 0, ans, 0, left + 1);
		ans[index] = merged;
		System.arraycopy(intervals, right, ans, index + 1, len - right);
		return ans;
	}
}
