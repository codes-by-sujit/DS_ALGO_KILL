package sliding_window;

public class LC_643_Max_Avg_SubArrya_1 {
    public double findMaxAverage(int[] nums, int k) {
        double ans=Integer.MIN_VALUE;
        int left=0;
        int right=0;
        int currSum = 0;
        for(;right<nums.length;right++){
            currSum+=nums[right];

            if(right>=k){
                double avg = (double)currSum/k;
                ans=Math.max(ans,avg);
            }

            if(right>k){
                currSum-=nums[left];
                left++;
            }
        }
        return ans;
    }
}
