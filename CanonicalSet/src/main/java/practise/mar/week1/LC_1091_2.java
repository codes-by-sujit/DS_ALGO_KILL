package practise.mar.week1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC_1091_2 {
    int m;
    int n;
    public int shortestPathBinaryMatrix(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        if(grid[0][0]!=0 || grid[m-1][n-1]!=0) return -1;
        if(m==1 && n==1) return 1;

        Queue<Integer[]> queue=new LinkedList<>();
        grid[0][0]=1;
        queue.offer(new Integer[]{0,0});
        int level=1;

        while(!queue.isEmpty()){
            int size=queue.size();
            while(size>0){
                Integer[] curr=queue.poll();
                int x=curr[0];
                int y=curr[1];
                for(Integer[] dir: getDirections(x,y)){
                    int nextX=dir[0];
                    int nextY=dir[1];
                    if(nextX==m-1 && nextY==n-1){
                        return level+1;
                    }
                    if(grid[nextX][nextY]==0){
                        grid[nextX][nextY]=1;
                        queue.offer(dir);
                    }
                }
                size--;
            }
            level++;
        }
        return level;
    }

    private List<Integer[]> getDirections(int i, int j){
        List<Integer[]> directions = new ArrayList<>();

        if(i+1<m && j+1<n)  directions.add(new Integer[]{i+1, j+1});  //BOTTOM-RIGHT
        if(i+1<m)                      directions.add(new Integer[]{i+1, j});    //BOTTOM
        if(i+1<m && j-1>=0)            directions.add(new Integer[]{i+1, j-1});  //BOTTOM-LEFT
        if(j-1>=0)                                directions.add(new Integer[]{i,   j-1});  //LEFT
        if(i-1>=0 && j-1>=0)                      directions.add(new Integer[]{i-1, j-1});  //TOP-LEFT
        if(i-1>=0)                                directions.add(new Integer[]{i-1, j});    //TOP
        if(i-1>=0 && j+1<n)            directions.add(new Integer[]{i-1, j+1});  //TOP-RIGHT
        if(j+1<m)                      directions.add(new Integer[]{i,   j+1});    //RIGHT

        return directions;
    }
}
