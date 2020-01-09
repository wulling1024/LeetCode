/**
 * @author wulling1024
 * @idea
 * @create 2019-03-15  11:13
 */
public class Finally {
    public int maxArea(int[] height){
        int maxarea = 0;
        int l=0;
        int r=height.length;
        while(l<r){
            maxarea = Math.max(maxarea,(r-l)*Math.min(height[r],height[l]));
            if (height[l] < height[r]){
                l++;
            }else{
                r++;
            }
        }
        return maxarea;
    }
}
