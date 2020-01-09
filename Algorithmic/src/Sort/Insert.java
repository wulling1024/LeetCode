package Sort;

/**
 * @author wulling1024
 * @idea
 * @create 2019-03-16  10:34
 * name: 直接插入排序
 * 思想： 1、从后不断往前进行插入
 *       2、不断将一个数插入到一个已序的序列中
 *
 */
public class Insert {
	public static int[] Direct(int[] nums){
		int i,j,n=nums.length;
		int temp;  // 作为过渡元素，即“哨兵”
		for(i=1;i<n;i++){
			temp = nums[i];
			if(nums[i]<nums[i-1]){
				for(j=i-1;j>=0;j--){
					if(nums[j]<=temp){  //碰到比自己 小或者等于 的元素
						break;
					}
					nums[j+1] = nums[j];
				}
				nums[j+1] = temp;
			}
		}
		return nums;
	}
}
