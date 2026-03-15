package prefix_sum.level_3;

import java.util.HashMap;
import java.util.Map;

public class LC_1590_Make_Sum_Divisible_By_P {
    public int minSubarray(int[] nums, int p) {
        //find the target
        //target is sum of sub-array if removed from main array then sum of remaining is divisible by p
        int sum=0;
        for(int n:nums){
            sum=(sum+n)%p;
        }
        int target=sum%p;
        if(target==0) return 0;
        int curr=0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            curr=(curr+nums[i])%p;
            int rem=(curr-target+p)%p;
            if(map.containsKey(rem)){
                int distance = i-map.get(rem);
                min=Math.min(min, distance);
            }
            map.put(curr,i);
        }
        return min>=nums.length?-1:min;
    }
}
/**

 */

