/**
 * @author wulling1024
 * @create 2019-03-26  21:39
 */
public class Solution2 {
	/**
	 * 一遍遍历求解
	 * 思想：两个指针之间控制间距
	 * 所有的操作都是针对于这一个链表的，只是开始的指针位置不同而已，并没有重新的新建一个
	 * 《固定间距法》
	 *
	 * @param head
	 * @param n
	 * @return
	 */
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode first = new ListNode(0);
		ListNode second = new ListNode(0);
		first.next = head; //指定指向
		second.next = head;
		int i = 0;
		while (i < (n + 1)) { //第一个指针前进n+1个位置
			first = first.next;
			i++;
		}
		while (first != null) { //两个指针共同进退
			first = first.next;
			second = second.next;
		}
		second.next = second.next.next; // 删除倒数第n个位置元素
		return head;
	}
}
