package two_pointer.level1;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class LC_977_Squares_of_sorted_array {
    public int[] sortedSquares(int[] nums) {
        int[] result=new int[nums.length];
        int index=nums.length-1;

        int start=0;
        int end=nums.length-1;

        while(start<=end){
            int sqrStart = nums[start]*nums[start];
            int sqrEnd = nums[end]*nums[end];

            if(sqrStart>=sqrEnd){
                result[index--]=sqrStart;
                start++;
            } else{
                result[index--]=sqrEnd;
                end--;
            }
        }
        return result;
    }



    @Test
    public void tc(){
        System.out.println(this.sortedSquares(new int[]{-1,2,2}));
        System.out.println(this.sortedSquares(new int[]{-5,-4,-3,-2,0,6,7}));
        System.out.println(this.sortedSquares(new int[]{-7,-3,2,3,11}));
    }

}
/**

 [-5,-4,-3,-2,0,6,7]
[25,16,9,4,0,36,49]
           i
 [0,4,9,16,25]
 temp=[]
 */
