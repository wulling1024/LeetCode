import java.util.Scanner;

/**
 * @author wulling1024
 * @idea
 * @create 2019-03-10  14:21
 */
public class test {
    public static void main(String[] args){
        // 输入语句
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int result = Solution.lengthOfLongestSubstring(str);
        System.out.println(result);
    }
}
