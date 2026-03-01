package practise.mar.week1;

import org.junit.Test;

public class LC_300_2 {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[] temp = new int[n];
        int size=0;
        for (int num : nums) {
            int lbIndex = lowerBound(temp, size, num);
            temp[lbIndex]=num;
            if (lbIndex == size) size++;
        }
        return size;
    }

    private int lowerBound(int[] nums, int size, int target){
        int l=0;
        int r=size;
        while(l<r){
            int mid=l+(r-l)/2;
            if(nums[mid]<target)
                l=mid+1;
            else
                r=mid;
        }
        return r;
    }

    @Test
    public void tc(){
        int[] nums = new int[]{1,2,2,2,3};
        System.out.println(this.lengthOfLIS(nums));
    }
    @Test
    public void tc3(){
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        System.out.println(this.lengthOfLIS(nums));
    }
    @Test
    public void tc2(){
        int[] nums = new int[]{};
        System.out.println(this.lowerBound(nums,0,3));
    }
}

/**
 [1,2,5,3,6]
 n:1 lowerbound is 0 => temp[1]
 n:2 lowerbound is 1 => temp[1,2]
 n:5 lowerbound is 2 => temp[1,2,5]
 n:3 lowerbound is 2 => temp[1,2,3]
 n:6 lowerbound is 2 => temp[1,2,3,6]
 return size(temp)
 lowerbound: next index where it's greater than target
 */
