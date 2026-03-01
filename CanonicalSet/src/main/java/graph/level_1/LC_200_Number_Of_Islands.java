package graph.level_1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC_200_Number_Of_Islands {
    int m;
    int n;
    public int numIslands(char[][] grid) {
        m=grid.length;
        n=grid[0].length;
        int counter=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(parseDepthFirst(grid,i,j)) counter++;
            }
        }
        return counter;
    }
    private boolean parseDepthFirst(char[][] grid, int i, int j){
        if(grid[i][j]!='1') return false;
        Queue<Integer[]> queue = new LinkedList<>();
        queue.offer(new Integer[]{i,j});
        grid[i][j]='2';
        while (!queue.isEmpty()) {
            Integer[] dir=queue.poll();
            int x=dir[0];
            int y=dir[1];
            for(Integer[] nextDir: getDirections(x,y)){
                if(grid[nextDir[0]][nextDir[1]]=='1'){
                    grid[nextDir[0]][nextDir[1]]='2';
                    queue.offer(nextDir);
                }
            }
        }
        return true;
    }
    private boolean parseBreadthFirst(char[][] grid,int i,int j){
        if(grid[i][j]!='1') return false;
        char c=grid[i][j];
        if(c=='1'){
            grid[i][j]='2';
            for(Integer[] dir:getDirections(i,j)){
                int x=dir[0];
                int y=dir[1];
                parseBreadthFirst(grid,x,y);
            }
            return true;
        }
        return false;
    }

    private List<Integer[]> getDirections(int i,int j){
        List<Integer[]> directions = new ArrayList<>();
        if(j-1>=0) directions.add(new Integer[]{i,j-1}); //LEFT
        if(j+1<n) directions.add(new Integer[]{i,j+1}); //RIGHT
        if(i+1<m) directions.add(new Integer[]{i+1,j}); //BOTTOM
        if(i-1>=0) directions.add(new Integer[]{i-1,j}); //TOP
        return directions;
    }
}
