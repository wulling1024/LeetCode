/**
 * @author wulling1024
 * @create 2019-03-25  20:36
 */
public class Finally {
    /**
     * 最优解
     * 定义双指针的进行遍历
     * 指针 i: 用于扫描数组中的所有元素
     * 指针 j: 用于赋值操作，直接提出相同的值
     */
    public static int removeElement(int[] nums, int val){
        int i=0,j=0;  // 定义双指针的位置
        for(;i<nums.length;i++){  // 用i进行全部遍历
            if(nums[i] != val){   // 直接剔除val值
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}
