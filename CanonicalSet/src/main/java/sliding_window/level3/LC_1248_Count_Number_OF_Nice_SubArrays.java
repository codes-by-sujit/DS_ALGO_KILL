package sliding_window.level3;

import org.junit.Test;

public class LC_1248_Count_Number_OF_Nice_SubArrays {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums,k)-atMost(nums,k-1);
    }
    private int atMost(int[] nums, int k){
        int i=0;
        int j=0;
        int counter=0;
        int oddCounter=0;
        for(;j<nums.length;j++){
            int curr=nums[j];
            if(curr%2==1)
                oddCounter++;

            while(oddCounter>k){
                int left=nums[i];
                if(left%2==1)
                    oddCounter--;
                i++;
            }
            counter+= (j-i)+1;
        }
        return counter;
    }

    @Test
    public void tc(){
        int[] nums = new int[]{1,1,2,1,1};
        System.out.println(this.numberOfSubarrays(nums,3));
    }
}
