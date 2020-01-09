/**
 * @author wulling1024
 * @idea
 * @create 2019-03-09  16:49
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int arr[]=new int[2];

        //跳出多层循环
        outer: //外层循环的标识符
        for(int i=0;i<nums.length-1;i++) {

            for(int j=i+1;j<nums.length;j++) {

                if(nums[i]+nums[j]==target) {
                    arr[0]=i;
                    arr[1]=j;
                    break outer;  //跳出两层循环
                }
            }
        }
        return arr;
    }
}
