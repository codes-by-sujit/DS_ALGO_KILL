package graph.level_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LC_542_01_Matrix {

    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int[][] result = new int[m][n];
        for(int i=0;i<m;i++)
            Arrays.fill(result[i],-1);
        Queue<Integer[]> queue=new LinkedList<>();

        //Check for all zeros which are having distance as : 0
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    result[i][j]=0;
                    queue.offer(new Integer[]{i,j});
                }
            }
        }

        //check next level
        while(!queue.isEmpty()){
            Integer[] current=queue.poll();
            int x=current[0];
            int y=current[1];
            for(int[] dir:getDirections()){
                int nextX=x+dir[0];
                int nextY=y+dir[1];
                if(nextX>=0 && nextX<m &&
                   nextY>=0 && nextY<n &&
                    result[nextX][nextY]==-1 //only unvisited
                  ){
                    result[nextX][nextY]=1+result[x][y];
                    queue.offer(new Integer[]{nextX,nextY});
                }
            }
        }
        return result;
    }



    private int[][] getDirections(){
        return new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    }
}
