package prefix_sum.level_1;

import org.junit.Test;

public class LC_304_RangeSum_Query_2D {
    class NumMatrix {
        int[][] ps;
        public NumMatrix(int[][] matrix) {
            ps=new int[matrix.length][matrix[0].length];
            for(int i=0;i<matrix.length;i++){
                ps[i][0]=matrix[i][0];
                for(int j=1;j<matrix[i].length;j++){
                    ps[i][j]=ps[i][j-1]+matrix[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum=0;
            for(int i=row1;i<=row2;i++){
                if(col1>0)
                    sum+= ps[i][col2]-ps[i][col1-1];
                else
                    sum+= ps[i][col2];
            }
            return sum;
        }
    }

    @Test
    public void tc(){
        int[][] matrix=new int[][]{{-4,-5}};
        NumMatrix obj = new NumMatrix(matrix);
        System.out.println(obj.sumRegion(0,0,0,1));
    }
}
/**
    3 0 1 4 2 => 3  3  4  8  10
    5 6 3 2 1 => 5 11 14 16  17 => 9
    1 2 0 1 5 => 1  3  3  4  9  => 2
 */
