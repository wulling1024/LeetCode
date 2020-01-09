/**
 * @idea
 * @wauthor wulling1024
 * @create 2018-12-14  19:07
 */
class Function {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=0;
        int i=0,j=0;
        int nums[]=new int[nums1.length+nums2.length];//定义一个合成数组
        for(;i<nums1.length&&j<nums2.length;){
            if(nums1[i]<nums2[j]){
                nums[m++]=nums1[i++];
            }else if(nums1[i]>nums2[j]){
                nums[m++]=nums2[j++];
            }else{
                nums[m++]=nums1[i++];
                nums[m++]=nums2[j++];
            }
        }
        if(i<nums1.length){
            for(;i<nums1.length;){
                nums[m++]=nums1[i++];
            }
        }else if(j<nums2.length){
            for(;j<nums2.length;){
                nums[m++]=nums2[j++];
            }
        }
        m--;
        if(m%2==0){
            return nums[m/2];
        }else{
            int a=m/2;
            double temp=(nums[a]+nums[a+1])/2.0;
            return temp;
        }
    }
}

public class Solution {

    public static void main(String[] args){

        int nums1[]={1,2};
        int nums2[]={-1,3};
        Function solution=new Function();
        double a=solution.findMedianSortedArrays(nums1,nums2);
        System.out.println("中位数："+a);
    }


}
