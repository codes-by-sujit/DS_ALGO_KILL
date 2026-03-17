package sliding_window;

import java.util.Deque;
import java.util.LinkedList;

public class LC_1245_Constrained_subsequence_sum {
    public int constrainedSubsetSum(int[] nums, int k) {
        int[] dp = new int[nums.length];
        Deque<Integer> dq = new LinkedList<>();
        int ans = Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            //Remove the old entries from dq first so that it should produce result under constraints
            while(!dq.isEmpty() && dq.peekFirst()<i-k){
                dq.pollFirst();
            }
            dp[i]=nums[i]; //default case
            if(!dq.isEmpty()){
                dp[i]=nums[i]+Math.max(0,dp[dq.peekFirst()]);
            }

            //Remove Elements from last to keep the monotonocity
            while(!dq.isEmpty() && dp[i]>=dp[dq.peekLast()]){
                dq.pollLast();
            }

            dq.offer(i);
            ans=Math.max(ans,dp[i]);
        }
        return ans;
    }
}
/**
 idea here is j-i<=k
 so between i & j gap is max k.
 so i-k .....i elements are considered for current scenario. between these elements find the max score
 */