package dp;

import org.junit.Test;

public class LC_152_Maximum_Product_Subarray {
    public int maxProduct(int[] nums) {
        int minProd = 1;
        int maxProd = 1;
        int max = Integer.MIN_VALUE;
        for(int num:nums){
            int tempMin = Math.min(num*minProd,num*maxProd);
            int tempMax  = Math.max(num*minProd,num*maxProd);
            minProd = Math.min(num, tempMin);
            maxProd = Math.max(num, tempMax);
            max = Math.max(max,Math.max(minProd,maxProd));
        }
        return max;
    }
    @Test
    public void tc(){
        int[] nums = new int[]{2,3,-2,4};
        System.out.println(this.maxProduct(nums));
    }
}
