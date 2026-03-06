package heap.level1;

import java.util.PriorityQueue;

public class LC_1046_Last_stone_weight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)-> Integer.compare(b,a));
        for(int stone:stones)
            pq.offer(stone);
        while(pq.size()>1){
            int x=pq.poll(); //heavy weight
            int y=pq.poll(); //light weight
            if(x==y) continue; //if both are equal, both are destroyed
            pq.offer(x - y);
        }
        return pq.isEmpty()?0:pq.peek();
    }
}
