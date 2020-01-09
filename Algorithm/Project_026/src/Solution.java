/**
 * @author wulling1024
 * @create 2019-03-25  15:30
 */
public class Solution {
    /**
     * 要求：原地操作，空间复杂度 o(1) 去除所有重复的元素
     * 1、先不断遍历数组元素
     * 2、每个遍历元素都与前方元素进行比较，就可判断是否初次出现
     * 3、将 temp 作为互异元素的统计量，并与相应位置的元素进行赋值更新操作
     */
    public int removeDuplicates(int[] nums){
        int temp = 1;
        for(int i = 1 ; i < nums.length ; i++){
            if(nums[i] != nums[i-1]){
                nums[temp] = nums[i];
                temp++;
            }
        }
        return temp;
    }
}
