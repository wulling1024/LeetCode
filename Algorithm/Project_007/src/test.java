import java.util.Scanner;

/**
 * @idea
 * @wauthor wulling1024
 * @create 2019-01-04  21:07
 */
class Solution{
    public int reverse(int x){
        if(x<0){
            int temp = -x;
            int g=0;
            int A[] = new int[50];
            for(int j=0;temp>0;j++){
                A[j]=temp%10;
                temp=temp/10;
                g++;
            }
            int result = 0;
            for(int j=0;g>0;){
                result += A[j++]*Math.pow(10,--g);
            }
            if((result>=Math.pow(2,31)-1)||result<=-Math.pow(2,31))
                result=0;
            result = -result;
            return result;
        }else if(x>0){
            int temp1 = x;
            int k=0;
            int B[] = new int[50];
            for(int j=0;temp1>0;j++){
                B[j]=temp1%10;
                temp1=temp1/10;
                k++;
            }
            int result = 0;
            for(int j=0;k>0;){
                result += B[j++]*Math.pow(10,--k);
            }
            if((result>=Math.pow(2,31)-1)||result<=-Math.pow(2,31))
                result=0;
            return result;
        }else{
            return x;
        }
    }
}
public class test {
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        int x = sc.nextInt();
        Solution solution =new Solution();
        int temp = solution.reverse(x);
        System.out.println(temp);
    }
}
