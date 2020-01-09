import java.util.Scanner;

/**
 * @idea
 * @wauthor wulling1024
 * @create 2018-12-02  12:03
 */
public class Main {
    private static int num=1000;

    public static void main(String[] args){
        int a[]=new int[num];
        System.out.print("请输入您想要判断的号码：");
        System.out.println("--------------------------");
        Scanner sc=new Scanner(System.in);
        long temp=sc.nextLong();
        long b=temp;
        if(temp>=0) {
            int i = 0;
            while (temp != 0) {
                a[i++] = (int) temp % 10;
                temp = temp / 10;
            }
            int j;
            for (j = 0; j < i; ) {
                if (a[j] == a[i - 1 - j]) {
                    j++;
                    continue;
                } else {
                    break;
                }
            }
            if (i == j) {
                System.out.println(b + "是回文数");
            } else {
                System.out.println(b + "不是回文数");
            }
        }else{
            System.out.println(b+"不是回文数");
        }
    }
}
