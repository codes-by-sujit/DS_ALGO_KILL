package graph.level_1;

import java.util.ArrayList;
import java.util.List;

public class LC_695_Max_Area_of_Island {
    int m;
    int n;
    public int maxAreaOfIsland(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        int max=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int area=areaInDepthFirstParse(grid,i,j);
                if(area>0)
                    max=Math.max(max,area);
            }
        }
        return max;
    }

    private int areaInDepthFirstParse(int[][] grid, int i, int j){
        if(grid[i][j]!=1) return 0;
        int area = 1;
        grid[i][j]=2;
        for(Integer[] dir:getDirections(i,j)){
            area+= areaInDepthFirstParse(grid,dir[0],dir[1]);
        }
        return area;
    }

    private List<Integer[]> getDirections(int i, int j){
        List<Integer[]> directions = new ArrayList<>();
        if(j-1>=0) directions.add(new Integer[]{i,j-1}); //LEFT
        if(j+1<n) directions.add(new Integer[]{i,j+1}); //RIGHT
        if(i+1<m) directions.add(new Integer[]{i+1,j}); //BOTTOM
        if(i-1>=0) directions.add(new Integer[]{i-1,j}); //TOP
        return directions;
    }
}
