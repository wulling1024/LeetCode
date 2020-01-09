import java.util.Scanner;

/**
 * @author wulling1024
 * @create 2019-03-27  12:48
 */
public class Test {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ListNode l1 = new ListNode(0); //头指针
        ListNode l2 = new ListNode(0); //头指针

        ListNode node = l1;
        int i = 1;
        while( i < 4){
//          int data = sc.nextInt();
//            ListNode pnode = new ListNode(sc.nextInt());
//            node.next = pnode;
            node.next = new ListNode(sc.nextInt());
            node = node.next;
            i++;
        }
        node = l2;
        i = 1;
        while( i < 4){
//          int data = sc.nextInt();
            ListNode pnode = new ListNode(sc.nextInt());
            node.next = pnode;
            node = node.next;
            i++;
        }
        ListNode result = Solution.mergeTwoLists(l1.next,l2.next);
    }
}
