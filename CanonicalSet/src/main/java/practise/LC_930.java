package practise;

import java.util.HashMap;
import java.util.Map;

public class LC_930 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int counter=0;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            counter+=map.getOrDefault(sum-goal,0);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return counter;
    }
}
/**
 10101 t=2
 11223
 -1-1001
 */
