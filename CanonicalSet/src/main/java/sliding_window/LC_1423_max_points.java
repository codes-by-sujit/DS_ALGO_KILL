package sliding_window;

import org.junit.Test;

public class LC_1423_max_points {
    public int maxScore(int[] cardPoints, int k) {
        int n=cardPoints.length; // total size

        int totalSum=0;
        for(int num:cardPoints)
            totalSum+=num;

        if(n==k) return totalSum; //If allowed to select all the numbers from the window then the total score

        //Calculate the 1st window sum
        int minWindowSum=Integer.MAX_VALUE;
        int windowSum=0;
        int windowSize=n-k;
        for(int i=0;i<windowSize;i++){
            windowSum+=cardPoints[i];
        }
        minWindowSum=windowSum;

        //Now move the window and envaluate min at each step

        for(int i=windowSize;i<n;i++){
            windowSum+=cardPoints[i];
            windowSum-=cardPoints[i-windowSize];
            minWindowSum=Math.min(windowSum,minWindowSum);
        }
        return totalSum-minWindowSum;
    }

    @Test
    public void test(){
        System.out.println(this.maxScore(new int[]{1,2,3,4,5,6,1},3));
    }
}
