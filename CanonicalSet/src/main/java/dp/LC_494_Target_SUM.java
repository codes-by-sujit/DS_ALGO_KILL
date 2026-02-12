package dp;

import java.util.HashMap;
import java.util.Map;

public class LC_494_Target_SUM {
    public int findTargetSumWays(int[] nums, int target) {
        //Maintain a map which holds number of possibilities for a target
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int num: nums){
            Map<Integer,Integer> tempMap = new HashMap<>();
            for(Map.Entry<Integer,Integer> e: map.entrySet()){
                int prevSum=e.getKey();
                int positiveSum = prevSum+num;
                int negativeSum = prevSum-num;
                tempMap.put(positiveSum, tempMap.getOrDefault(positiveSum,0)+e.getValue());
                tempMap.put(negativeSum, tempMap.getOrDefault(negativeSum,0)+e.getValue());
            }
            map = tempMap;
        }
        return map.getOrDefault(target, 0);
    }
}
