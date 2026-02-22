package sliding_window.level3;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LC_992_SubArrays_With_K_Different_Integers {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums,k)-atMost(nums,k-1);
    }

    private int atMost(int[] nums, int k){
        int i=0;
        int j=0;
        Map<Integer,Integer> map = new HashMap<>();
        int counter=0;
        for(;j<nums.length;j++){
            //Expand
            int curr=nums[j];
            map.put(curr,map.getOrDefault(curr,0)+1);

            //Shrink
            while(map.size()>k){
                int left=nums[i];
                map.put(left,map.get(left)-1);
                if(map.get(left)==0)
                    map.remove(left);
                i++;
            }
            //Validate
            counter+=(j-i)+1;
        }
        return counter;
    }
    @Test
    public void tc(){
        int[] nums = new int[]{1,2,1,2,3};
        System.out.println(this.subarraysWithKDistinct(nums,2));
    }
}
