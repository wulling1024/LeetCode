/**
 * @author wulling1024
 * @create 2019-03-26  16:01
 */
public class Solution {
    /**
     * 常数级遍历
     * 通过求解出链表的长度，进行逆向判断
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0); //新建头指针
        start.next = head;
        int len = Length(head);  // 获取长度
        ListNode temp = head;
        int i = 0;
        while(temp != null){
            if(len - n == 0){  // 排除待删除结点的前一个结点为null的情况
                start = start.next;
                break;
            }else {  // 前一个结点非null的情况
                i++;
                if (i == len - n) { //前移n的结点
                    //  ListNode node = temp.next;
                    temp.next = temp.next.next;  //删除结点
                    break;
                }
                temp = temp.next;
            }
        }
        return start.next;
    }
    public static int Length(ListNode temp){
        int i=1;
        while(temp.next != null) {
            i++;
            temp = temp.next;
        }
        return i;
    }
}
