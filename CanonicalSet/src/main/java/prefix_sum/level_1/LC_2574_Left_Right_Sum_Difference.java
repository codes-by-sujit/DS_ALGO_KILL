package prefix_sum.level_1;

public class LC_2574_Left_Right_Sum_Difference {
    public int[] leftRightDifference(int[] nums) {
        int n=nums.length;
        int[] leftSum=new int[n];
        int[] rightSum=new int[n];
        int[] result = new int[n];

        for(int i=0;i<n;i++){
            if(i==0){
                leftSum[i]=nums[0];
                continue;
            }
            leftSum[i]=leftSum[i-1]+nums[i];
        }

        for(int j=n-1;j>=0;j--){
            if(j==n-1){
                rightSum[j]=nums[j];
                continue;
            }
            rightSum[j]=rightSum[j+1]+nums[j];
        }

        for(int i=0;i<n;i++){
            result[i]=Math.abs(leftSum[i]-rightSum[i]);
        }
        return result;
    }
}
