package practise.mar.week1;

import java.util.LinkedList;
import java.util.Queue;

public class LC_547_1 {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        int provinence=0;
        boolean[] visited=new boolean[n];
        for(int city=0;city<n;city++){
            if(visited[city]) continue; //if city already visited
            Queue<Integer> nebCityQueue=new LinkedList<>();
            visited[city]=true;
            nebCityQueue.offer(city);
            while(!nebCityQueue.isEmpty()){
                int curr= nebCityQueue.poll();
                for(int j=0;j<n;j++){
                    if(!visited[j] && isConnected[curr][j]==1){
                        visited[j]=true;
                        nebCityQueue.offer(j);
                    }
                }
            }
            provinence++;
        }
        return provinence;
    }
}
