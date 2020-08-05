/**
 * @Author wulling1024
 * @Create 2020-01-13  16:48
 * @Description
 */
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class Solution {
	public static ListNode swapPairs(ListNode head) {
		ListNode start = new ListNode(100);
		ListNode result = head;
		start.next = head;
		while (head != null || head.next != null) {
			if (head.next.next != null) {
				ListNode temp = head.next;
				head.next = head.next.next;
				temp.next = head;
				start.next = temp;
				start = head;
				head = head.next;
			} else {
				ListNode temp = head.next;
				temp.next = head;
				start.next = temp;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		ListNode demo = new ListNode(0);
		ListNode result = demo;
		for (int i = 1; i < 5; i++) {
			ListNode node = new ListNode(i);
			demo.next = node;
			demo = demo.next;
		}

		result = swapPairs(result);

		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
	}
}
