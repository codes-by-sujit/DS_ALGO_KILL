package heap.level1;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LC_347_Top_K_Freq_Elements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Integer[]> pq=new PriorityQueue<>((a,b)->{
            return Integer.compare(b[1],a[1]);
        });
        int[] result = new int[k];
        for(int num:nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        for(Map.Entry<Integer,Integer> e: map.entrySet()){
            pq.offer(new Integer[]{e.getKey(),e.getValue()});
        }
        for(int i=0;i<k;i++){
            result[i]=pq.poll()[0];
        }
        return result;
    }
}
