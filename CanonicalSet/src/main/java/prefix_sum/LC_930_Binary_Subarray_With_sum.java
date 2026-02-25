package prefix_sum;

import java.util.HashMap;
import java.util.Map;

/**
 * 1,0,1,0,1   t=2
 * ps=[1,1,2,2,3]
 * ps[j]-k=ps[i]
 * so ps[j]-k
 * ps[i]=1,1,2,2,3
 * ps[j]-k=-1,-1,0,0,1
 */
public class LC_930_Binary_Subarray_With_sum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum=0;
        int counter=0;
        for (int num : nums) {
            sum += num;
            counter += map.getOrDefault(sum - goal, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return counter;
    }
}
