package com.testing.learndsa.arrays;

public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        for(int i=0;i<nums.length;i++){
            for(int j=i+indexDiff; j<nums.length; j+=indexDiff){
                if(Math.abs(nums[i]-nums[j])<=valueDiff)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicateIII duplicate = new ContainsDuplicateIII();
        System.out.println(duplicate.containsNearbyAlmostDuplicate(new int[]{1,5,9,1,5,9},2,3));
    }
}
