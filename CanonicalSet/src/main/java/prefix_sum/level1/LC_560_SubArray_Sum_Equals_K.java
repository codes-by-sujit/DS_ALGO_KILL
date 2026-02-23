package prefix_sum.level1;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LC_560_SubArray_Sum_Equals_K {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int counter=0;
        int sum=0;
        for(int num:nums){
            sum+=num; //PS[j]
            int temp = sum-k; //ps[j]-k
            counter+=map.getOrDefault(temp,0);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return counter;
    }

    @Test
    public void tc(){
        int[] nums = new int[]{1,2,3};
        System.out.println(this.subarraySum(nums,3));
    }

    @Test
    public void tc2(){
        int[] nums = new int[]{1,-1,0};
        System.out.println(this.subarraySum(nums,0));
    }
}
