package prefix_sum;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LC_974_Subarray_Sum_Divisible_By_K {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum=0;
        int counter=0;
        for(int num:nums){
            sum+=num;
            int rem = ((sum%k)+k)%k;
            counter+=map.getOrDefault(rem,0);
            map.put(rem,map.getOrDefault(rem,0)+1);
        }
        return counter;
    }

    @Test
    public void tc1(){
        int[] nums=new int[]{4,5,0,-2,-3,1};
        int k=5;
        System.out.println(this.subarraysDivByK(nums,k));
    }
    @Test
    public void tc2(){
        int[] nums=new int[]{-1,2,9};
        int k=2;
        System.out.println(this.subarraysDivByK(nums,k));
    }
}
/**
 * x%k=0
 * ps[i]+x=ps[j];
 * ps[i]%k + x%k =ps[j]%k
 * ps[i]%k=ps[j]%k
 */
