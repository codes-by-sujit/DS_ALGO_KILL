package practise;

import java.util.Deque;
import java.util.LinkedList;

public class LC_1425 {
    public int constrainedSubsetSum(int[] nums, int k) {
        int n=nums.length;
        int[] dp=new int[n]; //dp stores the max value at i;
        Deque<Integer> dq=new LinkedList<>();
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            //Remove the old items
            while(!dq.isEmpty() && dq.peekFirst()<i-k){
                dq.pollFirst();
            }
            dp[i]=nums[i];
            if(!dq.isEmpty()){
                dp[i]=nums[i]+Math.max(0, dp[dq.peekFirst()]);
            }
            while(!dq.isEmpty() && dp[i]>dq.peekLast()){
                dq.pollLast();
            }
            dq.offer(i);
            ans=Math.max(ans, dp[i]);
        }
        return ans;
    }

}
/**
 Subsequence -> dp
 length: n
 consecutive numbers are j-i>=k, that means max k
 hence window of size k
 */
