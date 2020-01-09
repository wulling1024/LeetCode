import java.util.Scanner;

/**
 * @author wulling1024
 * @create 2019-03-18  17:05
 */
public class Test {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[4];
        for(int i = 0;i<4;i++){
            nums[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        int result = Solution.threeSumClosest(nums,target);
        System.out.println(result);
    }
}
