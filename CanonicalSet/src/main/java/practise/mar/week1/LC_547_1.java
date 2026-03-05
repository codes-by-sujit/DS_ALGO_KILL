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
/**
Given the connectivity between cities.
 if connected : 1 else :0
 A->B-> that means A->C => here province count is 1
 how to approach? smallest input then gradually expand
 let's say city A. We will keep a visited[] to track if this city is visited or not
 if city A is already visited then go to next city
 if not then
    we need to find all neighbour city connected to A (direct path)
    And then from that neighbour city we will discover new path to unvisited city (transitive path)


 to achieve this we will parse all the connected paths from current city and
 consider only the path routes to unvisited city
 if any unvisited city found we will add to queue

 in this way in one iteration cycle we will cover all direct and transitive path from the city which will be counted as 1 province.

 as the iteration cycle increases we will increase this based on visited/not visited
 */
