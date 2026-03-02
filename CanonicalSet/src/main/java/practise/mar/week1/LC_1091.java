package practise.mar.week1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC_1091 {
    int maxRowLength;
    int maxColLength;
    public int shortestPathBinaryMatrix(int[][] grid) {
        maxRowLength = grid.length;
        maxColLength = grid[0].length;

        if(grid[0][0]!=0 || grid[maxRowLength-1][maxColLength-1]!=0) return -1;
        if(maxColLength==1 && maxRowLength==1) return 1;

        Queue<Integer[]> queue= new LinkedList<>();
        queue.offer(new Integer[]{0,0});
        grid[0][0]=1; //Marking the current cell to visited
        int level=1; //because the (0,0) cell already processed
        while(!queue.isEmpty()){
            int size=queue.size();
            while(size>0){ //Will poll only the directions belong to that level
                Integer[] currDir = queue.poll();
                int x=currDir[0];
                int y=currDir[1];
                for(Integer[] dir: getDirections(x,y)){
                    int nextX=dir[0];
                    int nextY=dir[1];
                    if(nextX==maxRowLength-1 && nextY==maxColLength-1)
                        return level+1;
                    if(grid[nextX][nextY]==0){
                        grid[nextX][nextY]=1;
                        queue.offer(dir);
                    }
                }
                size--;
            }
            level++;
        }
        return -1; //All Elements are passed but unable to reach target cell
    }


    private List<Integer[]> getDirections(int i, int j){
        List<Integer[]> directions = new ArrayList<>();

        if(i+1<maxRowLength && j+1<maxColLength)  directions.add(new Integer[]{i+1, j+1});  //BOTTOM-RIGHT
        if(i+1<maxRowLength)                      directions.add(new Integer[]{i+1, j});    //BOTTOM
        if(i+1<maxRowLength && j-1>=0)            directions.add(new Integer[]{i+1, j-1});  //BOTTOM-LEFT
        if(j-1>=0)                                directions.add(new Integer[]{i,   j-1});  //LEFT
        if(i-1>=0 && j-1>=0)                      directions.add(new Integer[]{i-1, j-1});  //TOP-LEFT
        if(i-1>=0)                                directions.add(new Integer[]{i-1, j});    //TOP
        if(i-1>=0 && j+1<maxColLength)            directions.add(new Integer[]{i-1, j+1});  //TOP-RIGHT
        if(j+1<maxColLength)                      directions.add(new Integer[]{i,   j+1});    //RIGHT

        return directions;
    }
}
