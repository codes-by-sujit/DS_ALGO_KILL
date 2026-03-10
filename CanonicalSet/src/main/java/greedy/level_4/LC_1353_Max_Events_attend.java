package greedy.level_4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LC_1353_Max_Events_attend {
    public int maxEvents(int[][] events) {
        int count=0;
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        int day=events[0][0];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int index=0;
        while(!pq.isEmpty()||index<events.length) {
            if(pq.isEmpty()){
                day=events[index][0];
            }
            while (index < events.length && events[index][0] == day) {
                pq.offer(events[index][1]);
                index++;
            }
            //consider the event which will finish first
            if (!pq.isEmpty()) {
                pq.poll();
                count++;
            }
            day++;

            while(!pq.isEmpty() && pq.peek()<day){
                pq.poll();
            }
        }
        return count;
    }
}
/**
 the idea is to go day by day.
 each day we can see if we can pick up any event -> for this we need to sort them as per start time

 day:1 => consider all the events starting at day 1.
 (1,2) (1,3) (1,4) (2,3) (2,4)
 */