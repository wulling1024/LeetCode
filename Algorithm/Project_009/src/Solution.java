/**
 * @idea
 * @wauthor wulling1024
 * @create 2018-12-03  13:00
 */
public class Solution {
    public boolean isPalindrome(int x){
        int a[] = new int[10];
        int i=0,j=0;
        int temp=x;
        if(x>=0){
            while(temp!=0){
                a[i++] = temp%10;
                temp = temp/10;
            }
            for (; j < i; ) {
                if (a[j] == a[i - 1 - j]) {
                    j++;
                    continue;
                } else {
                    break;
                }
            }
            if (i == j) {
                System.out.println(x + "是回文数");
                return true;
            } else {
                System.out.println(x + "不是回文数");
                return false;
            }
        }else {
            System.out.println(x + "不是回文数");
            return false;
        }
    }
}
