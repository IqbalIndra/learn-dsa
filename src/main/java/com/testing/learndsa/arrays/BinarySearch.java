package com.testing.learndsa.arrays;

public class BinarySearch {

    public int findTarget(int left,int right, int[] nums, int target, boolean isSearchLeft){
        int find = -1;
        while(left<=right){
            int mid = (right + left)/2;
            if(nums[mid] == target){
                find = mid;
                if(isSearchLeft){
                    right = mid -1;
                }else{
                    left = mid+1;
                }
            }else if(nums[mid] < target){
                left = mid +1;
            }else{
                right = mid -1;
            }
        }
        return find;
    }

    public static void main(String[] args) {
        int left = 0;
        int[] nums = {5,7,7,8,8,10};
        int right = nums.length -1;
        int target = 8;
        BinarySearch binarySearch = new BinarySearch();

        int first = binarySearch.findTarget(left,right,nums,target,false);
        //int last = findTarget(first,right,nums,target);
        System.out.println(first);
    }
}
