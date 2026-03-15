package prefix_sum.level_4;

import java.util.HashMap;
import java.util.Map;

public class LC_992_SubArrays_with_K_Distinct_Integers {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atmost(nums,k)-atmost(nums,k-1);
    }

    public int atmost(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        int count=0;
        int i=0;
        for(int j=0;j<nums.length;j++){
            //EXPAND
            map.put(nums[j], map.getOrDefault(nums[j],0)+1);

            //SHRINK
            while(map.size()>k){
                int leftNum=nums[i];
                map.put(leftNum,map.get(leftNum)-1);
                if(map.get(leftNum)==0)
                    map.remove(leftNum);
                i++;
            }

            //VALIDATE
            count+=(j-i)+1; //all the subarrays in between i->j are the possible combinations
        }
        return count;
    }
}
