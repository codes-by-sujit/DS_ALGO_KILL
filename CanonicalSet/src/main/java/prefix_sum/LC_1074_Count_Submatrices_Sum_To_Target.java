package prefix_sum;

import java.util.HashMap;
import java.util.Map;

public class LC_1074_Count_Submatrices_Sum_To_Target {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int counter=0;
        for(int top=0;top<m;top++){
            int[] colSum=new int[n];
            for(int bottom=top;bottom<m;bottom++){
                for(int i=0;i<n;i++){
                    colSum[i]+=matrix[bottom][i];
                }
                counter+=count(colSum,target);
            }
        }
        return counter;
    }

    private int count(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum=0;
        int counter=0;
        for(int num:nums){
            sum+=num;
            counter+=map.getOrDefault(sum-target,0);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return counter;
    }
}
