package dp.level_5;

import org.junit.Test;

public class LC_300_Longest_Increasing_Subsequence {
    public int lengthOfLIS(int[] nums) {
        int[] tail = new int[nums.length]; //Array to keep track of the subsequence
        int size=0; //Count of elements in tail
        for(int num:nums){
            int index=getLowerBoundIndex(tail,size,num); //find the lowerbound for num in tail array
            if(index==size) //last index means num is greater than all elements in tail
                size++; //hence add the element to tail and increase counter
            tail[index]=num;
        }
        return size; //total count of elements present in tail
    }
    /**
     * Consider the array is sorted
     *
     * LowerBound -> The Index of the  first element that is greater than or equal to target
     *                                 -------------         ---------------------
     * UpperBound -> The Index of the  first element that is greater than to target
     *                                 -------------        --------
     * Family -> Binary Search
     * 1 2 2 2 3 ->
     */
     private int getLowerBoundIndex(int[] nums, int size, int target){
         if(size==0) return 0; //if no element present or only 0 then return 0
         int l=0;    //consider the index of first element in array
         int r=size; //consider the index of last element in array
         while(l<r){
             int  mid=l+(r-l)/2; //to avoid integer overflow.
             if(nums[mid]<target) //strictly match < for lowerbound
                 l=mid+1;
             else
                 r=mid;
         }
         return r;
     }

    @Test
    public void tc(){
        int[] tail =  new int[3];
        System.out.println(tail.length);
    }
}
