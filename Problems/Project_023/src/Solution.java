/**
 * @Author wulling1024
 * @Create 2020-01-13  15:45
 * @Description
 */

/**
 * 定义结点信息
 */
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class Solution {

	public ListNode mergeKLists(ListNode[] lists) {
//		查找出开头值最小的链表
		ListNode result = findMinKLists(lists);

//		初始考虑结果链表至少含有两个结点
		ListNode start = result;
		ListNode end = start.next;

		for (int i = 0; i < lists.length; i++) {
			if (lists[i] != null && end != null) {
				while (end != null) {
					for (int j = 0; j < lists.length; j++) {
						if (lists[j].val > end.val) {
							continue;
						}
						while (lists[j].val <= end.val) {
							ListNode tag = start;
							while (tag != end) {
								if (start.val < lists[j].val && start.next.val >= lists[j].val) {
									ListNode temp = lists[j];
									lists[j] = lists[j].next;
									temp.next = tag.next;
									tag.next = temp;
								}
								tag = tag.next;
							}
						}
					}
				}
			}
		}
		return result;
	}

	/**
	 * 查找 K条 有序链表中开头值最小的那条链表
	 *
	 * @param lists
	 * @return
	 */
	private static ListNode findMinKLists(ListNode[] lists) {
		ListNode result = lists[0];
		for (int i = 1; i < lists.length; i++) {
			if (lists[i].val < result.val) {
				result = lists[i];
			}
		}
		return result;
	}

	public static void main(String[] args) {

	}
}
