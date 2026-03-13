package stack.Level_2;

import org.junit.Test;

import java.util.Stack;

public class LC_84_Largest_Rectangle {
    public int largestRectangleArea(int[] heights) {
        int[] nse= nextSmallerElements(heights);
        int[] pse= prevSmallerElements(heights);
        int max=Integer.MIN_VALUE;
        for(int i=0;i<heights.length;i++){
            max=Math.max(max, ((nse[i]-pse[i])-1)*heights[i]);
        }
        return max;
    }

    private int[] nextSmallerElements(int[] nums){
        Stack<Integer> stack=new Stack<>();
        int[] res=new int[nums.length];
        for(int i=nums.length-1;i>=0;i--){
            while(!stack.isEmpty() && nums[stack.peek()]>=nums[i]){
                stack.pop();
            }
            res[i]=stack.isEmpty()?nums.length:stack.peek();
            stack.push(i);
        }
        return res;
    }

    private int[] prevSmallerElements(int[] nums){
        Stack<Integer> stack=new Stack<>();
        int[] res=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            while(!stack.isEmpty() && nums[stack.peek()]>nums[i]){
                stack.pop();
            }
            res[i]=stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        return res;
    }

    @Test
    public void tc(){
        System.out.println(this.largestRectangleArea(new int[]{2,1,5,6,2,3}));
        System.out.println(this.largestRectangleArea(new int[]{2,4}));
    }
}
