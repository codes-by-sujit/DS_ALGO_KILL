package graph.level_1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC_547_Number_of_provinces {
    public int findCircleNum(int[][] isConnected) {
      int totalCity=isConnected.length;
      int provinces=0;
      boolean[] visitedCity=new boolean[totalCity];
      for(int i=0;i<totalCity;i++){ //parse each city
          if(visitedCity[i]) continue; //already visited

          provinces++;
          visitedCity[i]=true;
          Queue<Integer> queue = new LinkedList<>();
          queue.offer(i);
          while(!queue.isEmpty()){
              int currentCity = queue.poll();
              visitedCity[currentCity]=true;
              for(int j=0;j<totalCity;j++){
                  if(isConnected[currentCity][j]==1 && !visitedCity[j])
                      queue.offer(j);
              }
          }
      }
      return provinces;
    }


}

/**
 1 0 0 1
 0 1 1 0
 0 1 1 1
 1 0 1 1
 */
