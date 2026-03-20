package practise;

import java.util.Deque;
import java.util.LinkedList;

public class LC_862_Shortest_SubArray_Sum_Atleast_K {
    public int shortestSubarray(int[] nums, int k) {
        int n=nums.length;
        //Calculate prefix Sum of all numbers
        int[] ps=new int[n+1];
        for(int i=0;i<n;i++)
            ps[i+1]=ps[i]+nums[i];
        Deque<Integer> dq=new LinkedList<>();
        int ans=Integer.MAX_VALUE;

        for(int i=0;i<=n;i++){
            //Keep on checking the answer from the best candidates of dq.
            while(!dq.isEmpty()&& ps[i]-k>=ps[dq.peekFirst()]){
                int temp=dq.pollFirst();
                ans=Math.min(ans,i-temp);
            }

            //Remove the unnecessary nums to make it monotonic
            while(!dq.isEmpty() && ps[i]<=ps[dq.peekLast()]){
                dq.pollLast();
            }
            dq.offer(i);
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}
/**
 i/p->nums[], k
 find min subarray ->sliding window or ps
 nums[i] contains -ve so sliding window may not work.
 */
