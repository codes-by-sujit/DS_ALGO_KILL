package prefix_sum.level_5;

public class LC_2016_Max_Diff {
    public int maximumDifference(int[] nums) {
        int ans=-1;
        int minSoFar=nums[0];
        for(int i=1;i<nums.length;i++){
            //if good candidate found for diff
            if(nums[i]>minSoFar){
                ans=Math.max(ans, nums[i]-minSoFar);
            } else {
                minSoFar=nums[i];
            }
        }
        return ans;
    }
}
