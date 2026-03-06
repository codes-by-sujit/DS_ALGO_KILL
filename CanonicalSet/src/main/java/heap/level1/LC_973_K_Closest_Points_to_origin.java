package heap.level1;

import org.junit.Test;

import java.util.PriorityQueue;

public class LC_973_K_Closest_Points_to_origin {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->{
            double d1=getDistance(a);
            double d2=getDistance(b);
            return Double.compare(d1,d2);
        });

        for(int[] cord: points){
            pq.offer(cord);
        }

        int[][] result = new int[k][2];
        for(int i=0;i<k;i++){
            result[i]=pq.poll();
        }
        return result;
    }

    private double getDistance(int[] coordinates){
        int x1=coordinates[0];
        int y1=coordinates[1];
        int x2=0;
        int y2=0;
        return Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2));
    }

    @Test
    public void tc(){
        System.out.println(Math.sqrt(162));
        System.out.println(Math.sqrt(135));
        System.out.println(Math.sqrt(149));
    }
}
