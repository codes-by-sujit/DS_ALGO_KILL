package prefix_sum;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LC_525_Contigious_Array {
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int max=Integer.MIN_VALUE;
        int sum=0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) nums[i]=-1;
            sum+=nums[i];
            map.put(sum,map.getOrDefault(sum,i));
            int diff = i-map.get(sum);
            max=Math.max(max,diff);
        }
        return max;
    }

    @Test
    public void tc(){
        int[] nums=new int[]{0,1,1,1,1,1,0,0,0};
        System.out.println(this.findMaxLength(nums));
    }

    @Test
    public void tc2(){
        int[] nums=new int[]{0,1,0,1};
        System.out.println(this.findMaxLength(nums));
    }

}
/**

 [1,0,1,0]
 [1,-1,1,-1]
 [1,0,1,0]

k-> should have balance 1 & -1 so sum is 0
 ps[i]==ps[j]

 -1,1,1,1,1,1,-1,-1,-1
            -1,0,1,2,3,4,3,2,1 ---key
 first seen  0,1,2,3,4,5,4,3,2 ---val
 j           0,1,2,3,4,5,6,7,8
dist         0,0,0,0,0,0,2,4,6
 */
