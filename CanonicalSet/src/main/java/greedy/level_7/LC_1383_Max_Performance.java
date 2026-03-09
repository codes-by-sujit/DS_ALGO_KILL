package greedy.level_7;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class LC_1383_Max_Performance {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        List<int[]> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new int[]{speed[i],efficiency[i]});
       }
        //max efficiency max performance
        list.sort((a,b)-> Integer.compare(b[1],a[1]));
        long max = Integer.MIN_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //Will keep the min speeds
        long speedSum=0;
        for (int[] ints : list) {
            int s = ints[0];
            int e = ints[1];
            pq.offer(s);
            speedSum += s;
            if (pq.size() > k) {
                speedSum -= pq.poll();
            }
            max = Math.max(max, speedSum * e);
        }
        return (int)(max % 1000000007);
    }

    @Test
    public void tc(){
        int n = 6;
        int[] speed = new int[]{2,10,3,1,5,8};
        int[] efficiency = new int[] {5,4,3,9,7,2};
        int k = 2;
        System.out.println(this.maxPerformance(n,speed,efficiency,k));
    }
}
