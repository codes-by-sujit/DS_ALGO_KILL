package sliding_window;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LC_1004_Max_Consecutive_Ones_III {

    public int longestOnes(int[] nums, int k) {
        int i=0;
        int j=0;
        int maxLen=0;
        Map<Integer,Integer> map = new HashMap<>();
        for(;j<nums.length;j++){
            //Expand
            if(nums[j]==0) map.put(0,map.getOrDefault(0,0)+1);

            //Shrink
            while(map.containsKey(0) && map.get(0)>k){
                int left = nums[i];
                if(left==0) map.put(0,map.get(0)-1);
                i++;
            }

            //Validate
            maxLen = Integer.max(maxLen,  (j-i)+1);
        }
        return maxLen;
    }

    @Test
    public void tc(){
        int[] nums = new int[]{1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(this.longestOnes(nums,2));
    }
    @Test
    public void tc2(){
        int[] nums = new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        System.out.println(this.longestOnes(nums,3));
    }
    @Test
    public void tc3(){
        int[] nums = new int[]{1};
        System.out.println(this.longestOnes(nums,1));
    }
}
