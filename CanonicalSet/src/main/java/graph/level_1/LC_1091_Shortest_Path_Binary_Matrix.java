package graph.level_1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC_1091_Shortest_Path_Binary_Matrix {
    int m;
    int n;
    public int shortestPathBinaryMatrix(int[][] grid) {
      m=grid.length;
      n=grid[0].length;

      if(grid[0][0]!=0 || grid[m-1][n-1]!=0) return -1;
      if(m==1 && n==1) return 1;

      int level=1;
      Queue<Integer[]> queue = new LinkedList<>();
      queue.offer(new Integer[]{0,0});
      grid[0][0]=1;
      while(!queue.isEmpty()){
          int size=queue.size(); //Size of current level;
          while(size>0){
              Integer[] pos = queue.poll();
              int x=pos[0];
              int y=pos[1];
              grid[x][y]=1;
              for(Integer[] nextPos:getDirections(x,y)){
                  int nextX=nextPos[0];
                  int nextY=nextPos[1];
                  if(nextX==m-1 && nextY==n-1)
                      return level+1;
                  if(grid[nextX][nextY]==0){
                      grid[nextX][nextY]=1;
                      queue.offer(nextPos);
                  }
              }
              size--;
          }
          level++;
      }
      return -1;
    }

    private List<Integer[]> getDirections(int i, int j){
        List<Integer[]>         directions = new ArrayList<>();
        if(j-1>=0)              directions.add(new Integer[]{i,j-1});       //LEFT
        if(j+1<n)               directions.add(new Integer[]{i,j+1});       //RIGHT
        if(i+1<m)               directions.add(new Integer[]{i+1,j});       //BOTTOM
        if(i-1>=0)              directions.add(new Integer[]{i-1,j});       //TOP
        if(i+1<m && j+1<n)      directions.add(new Integer[]{i+1,j+1});     //BOTTOM-RIGHT
        if(i+1<m && j-1>=0)     directions.add(new Integer[]{i+1,j-1});     //BOTTOM-LEFT
        if(i-1>=0 && j+1<n)      directions.add(new Integer[]{i-1,j+1});     //TOP-RIGHT
        if(i-1>=0 && j-1>=0)     directions.add(new Integer[]{i-1,j-1});     //TOP-LEFT

        return directions;
    }

    @Test
    public void tc(){
        int[][] nums = new int[][]{{0,1},{1,0}};
        System.out.println(this.shortestPathBinaryMatrix(nums));
    }
}
