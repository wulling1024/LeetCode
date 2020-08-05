/**
 * @idea
 * @wauthor wulling1024
 * @create 2019-01-08  9:36
 * 官方解答：直接对链表进行操作，这样就不会出现数据的溢出
 */
public class Solution1 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode node = new ListNode(0);
		ListNode prenode = node;
		int count = 0;
		while (l1 != null || l2 != null || count != 0) {
			count /= 10;
			if (l1 != null) {
				count += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				count += l2.val;
				l2 = l2.next;
			}
			prenode.next = new ListNode(count % 10);
			prenode = prenode.next;
		}
		if (count / 10 != 0)
			prenode.next = new ListNode(1);
		return node;
	}
}
