import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wulling1024
 * @create 2019-03-18  20:41
 */
public class Solution {
    public static List<List<Integer>> fourSum(int[] nums,int target) {
        //先对数组进行排序
        Arrays.sort(nums);
        //创建二维数组列表
        List<List<Integer>> arrays = new ArrayList<>();
   //     List<Integer> arrays2 = new ArrayList<>();

        for (int i = 0; i < nums.length-3; i++) {  // 头指针
            if ( nums.length < 4) {   // 直接不符合
                break;
//            }else if(nums[i] == nums[i+1] ){
//                i++;
//                continue;
            } else {
                for(int j=nums.length-1;j>i;j--) {  // 尾指针
//                    if(nums[j] == nums[j-1]){
//                        j--;
//                        continue;
//                    }else {
                        for (int p = i + 1, q = j - 1; p < q; ) {   // 双端操作指针
                            if (nums[i] + nums[p] + nums[q] + nums[j]> target) {
                                while (p < q && nums[q] == nums[q - 1])  // 排除相同的元素
                                    q--;
                                q--;
                            } else if (nums[i] + nums[p] + nums[q] + nums[j] < target) {
                                while (p < q && nums[p] == nums[p + 1])
                                    p++;
                                p++;
                            } else {
                                if(!arrays.contains(Arrays.asList(nums[i], nums[p], nums[q],nums[j])))
                                    arrays.add(Arrays.asList(nums[i], nums[p], nums[q],nums[j]));
                                while (p < q && nums[q] == nums[q - 1])
                                    q--;
                                q--;
                                while (p < q && nums[p] == nums[p + 1])
                                    p++;
                                p++;
                            }
                        }
                }
            }
        }
        return arrays;
    }
}
