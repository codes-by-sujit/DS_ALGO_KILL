package sliding_window;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC_862_Shortest_SubArray_Sum_k {
    public int shortestSubarray(int[] nums, int k) {
        //it has -ve elements so only sliding window may not work.
        long[] ps=new long[nums.length+1];
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            ps[i+1]=ps[i]+nums[i];
        }
        Deque<Integer> dq = new ArrayDeque<>(); //persist the index in monotonic way
        for(int j=0;j<=nums.length;j++){
            //Check the answer
            while(!dq.isEmpty() && ps[j]-ps[dq.peekFirst()]>=k){
                int i= dq.pollFirst();
                ans=Math.min(ans, j-i);
            }

            //remove elements from dq before inserting which wont give us best result
            while(!dq.isEmpty() && ps[j]<=ps[dq.peekLast()]){
                dq.pollLast();
            }
            dq.offerLast(j);
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }

    @Test
    public void test(){
        System.out.println(this.shortestSubarray(new int[]{2,-1,2}, 3));
    }
}
