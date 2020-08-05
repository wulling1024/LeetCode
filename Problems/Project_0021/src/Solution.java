/**
 * @author wulling1024
 * @create 2019-03-27  11:45
 * 注意：
 * 需要判断下一个结点是否存在
 * 如果不存在，则需要构造一个；如果存在，则可以进行赋值操作
 */
public class Solution {
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(0);  // 合并链表的头结点（头指针）
		ListNode start = result;  // 操作指针指向该链表
//        result.next = start;
		while (l1 != null && l2 != null) {
			if (l1.val > l2.val) {
				start.next = new ListNode(l2.val);  // 创建新结点
				start = start.next;
				l2 = l2.next;
//                start.val = l2.val;
//                l2 = l2.next;
//                ListNode node = new ListNode(0);
//                start.next = node;
//                start.next = new ListNode(0);
//                start = start.next;
			} else if (l1.val < l2.val) {
				start.next = new ListNode(l1.val);
				start = start.next;
				l1 = l1.next;
//                start.val = l1.val;
//                l1 = l1.next;
//                start.next = new ListNode(0);
//                start = start.next;
			} else {
				start.next = new ListNode(l1.val);
				start = start.next;
				l1 = l1.next;
				start.next = new ListNode(l2.val);
				start = start.next;
				l2 = l2.next;
//                start.val = l1.val;
//                l1 = l1.next;
//                start.next = new ListNode(0);
//                start = start.next;
//                start.val = l2.val;
//                l2 = l2.next;
//                start.next = new ListNode(0);
//                start = start.next;
			}
		}
		if (l1 != null) {
			start.next = l1;  // 富于长度的处理
		}
		if (l2 != null) {
			start.next = l2;
		}
		return result.next;
	}
}
