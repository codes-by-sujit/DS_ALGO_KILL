package practise;

import java.util.HashMap;
import java.util.Map;

public class LC_1248 {
    public int numberOfSubarrays(int[] nums, int k) {
        int counter=0;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i]%2;
            counter+=map.getOrDefault(sum-k,0);
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return counter;
    }
}
/**

 1  1  2  1  1
 1  1  0  1  1 when %2
 1  2  2  3  3
 -2 -1 -1 0  0

   2 4 6
   0 0 0

 */