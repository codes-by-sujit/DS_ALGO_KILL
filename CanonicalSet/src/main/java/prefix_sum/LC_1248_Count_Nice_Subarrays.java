package prefix_sum;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * convert each num to 1 or 0
 * sub array sum= k
 */
public class LC_1248_Count_Nice_Subarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum=0;
        int counter=0;
        for(int num:nums){
            sum+=num%2;
            counter+=map.getOrDefault(sum-k,0);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return counter;
    }
    @Test
    public void tc(){
        int[] nums = new int[]{1,1,2,1,1};
        System.out.println(this.numberOfSubarrays(nums,3));
    }

    @Test
    public void tc2(){
        int[] nums = new int[]{2,2,2,1,2,2,1,2,2,2};
        System.out.println(this.numberOfSubarrays(nums,2));
    }
}
