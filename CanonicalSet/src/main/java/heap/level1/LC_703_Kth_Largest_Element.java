package heap.level1;

import java.util.PriorityQueue;

public class LC_703_Kth_Largest_Element {
    class KthLargest {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{return Integer.compare(a,b);});
        int k;
        public KthLargest(int k, int[] nums) {
            this.k=k;
            for(int num:nums){
                add(num);
            }
        }

        public int add(int val) {
            pq.offer(val);
            if(pq.size()>k)
                pq.poll();
            return pq.peek();
        }
    }
}
/**
 1,2,3,4

  2
 3 4
 */