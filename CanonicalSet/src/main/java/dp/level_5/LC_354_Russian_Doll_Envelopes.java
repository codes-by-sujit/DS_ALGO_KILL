package dp.level_5;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class LC_354_Russian_Doll_Envelopes {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        int[] tails = new int[envelopes.length];
        int size = 0;

        for (int[] e : envelopes) {
            int h = e[1];
            int i = 0, j = size;
            while (i < j) {
                int mid = i + (j - i) / 2;
                if (tails[mid] < h) i = mid + 1;
                else j = mid;
            }
            tails[i] = h;
            if (i == size) size++;
        }

        return size;

    }

    private int getLIS(int[] nums){
        int[] dp=new int[nums.length];
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i])
                    dp[i]=Math.max(dp[j]+1, dp[i]);
            }
            max=Math.max(max, dp[i]);
        }
        return max;
    }

    @Test
    public void tc(){
        int[][] envs = new int[][]{{5,4},{6,4},{6,7},{2,3}};
        System.out.println(this.maxEnvelopes(envs));
    }
}
