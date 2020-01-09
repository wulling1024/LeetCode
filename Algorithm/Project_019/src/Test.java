import java.util.Scanner;

/**
 * @author wulling1024
 * @create 2019-03-26  16:41
 */
public class Test {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ListNode start = new ListNode(0); //头指针
        ListNode node = start;
//        node = start;
        int i = 1;
        while( i < 6){
//          int data = sc.nextInt();
            ListNode pnode = new ListNode(sc.nextInt());
            node.next = pnode;
            node = node.next;
            i++;
        }
        System.out.println("请输入n值：");
        int n = sc.nextInt();
        ListNode out = Solution2.removeNthFromEnd(start.next,n);
        while(out != null) {
            System.out.println(out.val);
            out = out.next;
        }
    }
}
