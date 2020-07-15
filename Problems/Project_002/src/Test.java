import java.util.ArrayList;
import java.util.Scanner;

/**
 * @idea
 * @wauthor wulling1024
 * @create 2019-01-05  12:03
 */
public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("第一个非空数的逆序表达式为：");
		int temp = sc.nextInt();
		System.out.println(temp);
		System.out.print("第二个非空数的逆序表达式为：");
		int temp2 = sc.nextInt();
		System.out.println(temp2);


		ListNode l2 = null;
		//如何把逆序转换成链表形式
		//利用一个数组进行存储
		ArrayList<Integer> array1 = new ArrayList<Integer>();
		while (temp != 0) {
			int i = temp % 10;
			array1.add(i);
			temp /= 10;
		}
		// System.out.println(array1.get(2));
		ListNode l1 = null;
		ListNode l11 = l1;
		for (int i = array1.size() - 1; i >= 0; i--) {
			l1 = new ListNode(array1.get(i));
			// System.out.println(l1.node);
			l1 = l1.next;
		}
		while (l11.next != null) {
			System.out.println(l11.val);
		}
		ArrayList<Integer> array2 = new ArrayList<Integer>();
		while (temp2 != 0) {
			int i = temp2 % 10;
			array2.add(i);
			temp2 /= 10;
		}
		for (int i = array2.size() - 1; i >= 0; i--) {
			l2.val = array2.get(i);
			l2 = l2.next;
		}
		l2 = null;
		Solution solution = new Solution();
		l1 = solution.AddTwoNumbers(l1, l2);
		System.out.println(l1);
	}
}
