package binarySearch.level_1;

import org.junit.Test;

public class LC_34_First_and_LastPosition {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{
                getFirstPos(nums,target),
                getLastPos(nums,target)
        };
    }
    private int getFirstPos(int[] nums,int target){
        if(nums.length==0) return -1;
        int i=0;
        int j=nums.length-1;
        int pos=Integer.MAX_VALUE;
        while(i<=j){
            int mid=i+(j-i)/2;
            if(target<=nums[mid]){
                if(target==nums[mid])pos=mid;
                j=mid-1;
            } else{
                i=mid+1;
            }
        }
        return pos==Integer.MAX_VALUE?-1:pos;
    }

    private int getLastPos(int[] nums, int target){
        int pos=Integer.MAX_VALUE;
        int i=0;
        int j=nums.length-1;
        if(nums.length==0) return -1;
        while(i<=j){
            int mid=i+(j-i)/2;
            if(target>=nums[mid]){
                if(target==nums[mid])pos=mid;
                i=mid+1;
            } else{
                j=mid-1;
            }
        }
        return pos==Integer.MAX_VALUE?-1:pos;
    }

    @Test
    public void tc(){
        int[] nums = new int[]{1,2,2,2,5};
        System.out.println(this.getFirstPos(nums,3));
        System.out.println(this.getLastPos(nums,2));
    }
}
