package sliding_window.level2;

import java.util.HashMap;
import java.util.Map;

public class LC_1695_Maximum_Erasure_Value {
    public int maximumUniqueSubarray(int[] nums) {
        int i=0;
        int j=0;
        int sum=0;
        int maxScore = Integer.MIN_VALUE;
        Map<Integer,Integer> map = new HashMap<>();
        for(;j<nums.length;j++){
            int curr = nums[j];
            sum+=curr;
            map.put(curr,map.getOrDefault(curr,0)+1);

            while(map.get(curr)>1){
                int leftNum=nums[i];
                sum-=leftNum;
                map.put(leftNum,map.get(leftNum)-1);
                if(map.get(leftNum)==0)
                    map.remove(leftNum);
                i++;
            }
            maxScore=Math.max(maxScore, sum);
        }
        return maxScore;
    }
}
