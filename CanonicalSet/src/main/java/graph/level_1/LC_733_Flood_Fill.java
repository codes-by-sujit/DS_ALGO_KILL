package graph.level_1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LC_733_Flood_Fill {
    int m;
    int n;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        m=image.length;
        n=image[0].length;
        floodFillDFS(image,sr,sc,image[sr][sc],color);
        return image;
    }

    private void floodFillDFS(int[][] image, int i, int j, int original, int color){
        if(image[i][j]!=original || image[i][j]==color) return;
        image[i][j]=color;
        for(Integer[] dir: getDirections(i,j)){
            floodFillDFS(image,dir[0],dir[1],original,color);
        }
    }

    private List<Integer[]> getDirections(int i, int j){
        List<Integer[]> directions = new ArrayList<>();
        if(j-1>=0) directions.add(new Integer[]{i,j-1}); //LEFT
        if(j+1<n) directions.add(new Integer[]{i,j+1}); //RIGHT
        if(i+1<m) directions.add(new Integer[]{i+1,j}); //BOTTOM
        if(i-1>=0) directions.add(new Integer[]{i-1,j}); //TOP
        return directions;
    }

    @Test
    public void tc(){
        int[][] image = new int[][]{{1,1,1},{1,1,0},{1,0,1}};
        System.out.println(this.floodFill(image,1,1,2));
    }
}
