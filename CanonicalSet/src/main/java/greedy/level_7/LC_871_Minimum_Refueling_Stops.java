package greedy.level_7;

import org.junit.Test;

import java.util.Collections;
import java.util.PriorityQueue;

public class LC_871_Minimum_Refueling_Stops {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int maxReach=startFuel;
        int count=0;
        int index=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        while(maxReach<target){
            while(index<stations.length && stations[index][0]<=maxReach){
                pq.offer(stations[index][1]);
                index++;
            }
            if(pq.isEmpty()) return -1;
            else{
                maxReach+=pq.poll();
                count++;
            }
        }
        return count;
    }

    @Test
    public void tc(){
        int[][] stations = new int[][]{{10,60},{20,30},{30,30},{60,40}};
        System.out.println(this.minRefuelStops(100,10,stations));
    }
    @Test
    public void tc2(){
        int[][] stations = new int[][]{{10,60},{20,30},{30,30},{60,40}};
        System.out.println(this.minRefuelStops(100,10,stations));
    }
}
