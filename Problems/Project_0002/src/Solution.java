/**
 * @idea
 * @wauthor wulling1024
 * @create 2019-01-05  11:49
 * 弊端：这种先把链表转化为数，然后两数相加，重新转化为链表，很容易造成“数据的溢出”
 * 在极大值测试时，就会通过不了
 */
public class Solution {
	public ListNode AddTwoNumbers(ListNode l1, ListNode l2) {
		long L1 = 0, L2 = 0;
		int i = 0, j = 0;
		while (l1 != null) {
			System.out.println(l1.val);
			L1 += l1.val * Math.pow(10, i++);
			l1 = l1.next;
		}
		while (l2 != null) {
			L2 += l2.val * Math.pow(10, j++);
			l2 = l2.next;
		}
		long temp = L1 + L2;
		System.out.println(temp);
		ListNode l3 = new ListNode(0);
		ListNode p = l3;
		if (temp == 0) {
			return l3;
		}
		while (temp != 0) {
			long a = temp % 10;
			System.out.println(a);
			p.next = new ListNode((int) a);
			p = p.next;
			temp /= 10;
		}
		return l3.next;
	}
}
