package com.testing.learndsa.arrays;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> findthreeSum(int[] nums) {
        //-4,-1,-1,0,1,2
        List<List<Integer>> result = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++){
            int start = i+1 , end = nums.length-1;
            while(start<end){
                int current = nums[i]+nums[start]+nums[end];
                if(current < 0)
                    start++;
                else if(current > 0)
                    end--;
                else{
                    Integer[] triplet = new Integer[] {nums[i],nums[start],nums[end]};
                    String key = nums[i]+"-"+nums[start]+"-"+nums[end];
                    if(!map.containsKey(key)){
                        map.put(key , 1);
                        result.add(Arrays.asList(triplet));
                    }
                    start++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.findthreeSum(new int[] {-1,0,1,2,-1,-4}));
    }
}
