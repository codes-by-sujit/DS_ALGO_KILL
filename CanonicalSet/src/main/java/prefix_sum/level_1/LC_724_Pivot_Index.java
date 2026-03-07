package prefix_sum.level_1;

public class LC_724_Pivot_Index {
    public int pivotIndex(int[] nums) {
        int n=nums.length;
        int[] leftToRightSum = new int[n];
        int[] rightToLeftSum = new int[n];

        for(int i=0;i<n;i++){
            if(i==0){
                leftToRightSum[i]=nums[0];
                continue;
            }
            leftToRightSum[i]=leftToRightSum[i-1]+nums[i];
        }

        for(int j=n-1;j>=0;j--){
            if(j==n-1){
                rightToLeftSum[j]=nums[j];
                continue;
            }
            rightToLeftSum[j]=rightToLeftSum[j+1]+nums[j];
        }
        for(int i=0;i<n;i++){
            if(leftToRightSum[i]==rightToLeftSum[i])
                return i;
        }
        return -1;
    }
}
