package practise.mar.week1;

import java.util.HashMap;
import java.util.Map;

public class LC_560 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int sum=0;
        int count=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            count+=map.getOrDefault(sum-k,0);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
/**
 [1,2,3] k=3
 ps [1,3,6]
 0->1

 let's say subarray x has sum of k
 ps[i]+k=ps[j]
 ps[j]-k=ps[i];
 map
 when no element choosen then sum 0 so) is seen once hence
 init map with {0->1}
 */