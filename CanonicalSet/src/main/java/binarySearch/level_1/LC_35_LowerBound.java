package binarySearch.level_1;

import org.junit.Test;

public class LC_35_LowerBound {
    public int searchInsert(int[] nums, int target) {
        int n=nums.length;
        int i=0;
        int j=n-1;
        if(target>nums[j]) return j+1;
        if(target<nums[i]) return i;
        int pos=0;
        while(i<j){
            int mid=i+(j-i)/2;
            if(target<=nums[mid]){
                pos=mid;
                j=mid-1;
            } else{
                i=mid+1;
            }
        }
        return pos;
    }

    @Test
    public void tc(){
        System.out.println(this.searchInsert(new int[]{1,3,5,6},2));
        System.out.println(this.searchInsert(new int[]{1,3,5,6},7));
    }
}

/**
  1 3 3 3 4
  0 1 2 3 4
 */
