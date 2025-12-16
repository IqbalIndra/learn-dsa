package com.testing.learndsa.hashmap;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int subarraySum(int[] nums, int target){
        //2,-1,1,2

        int currSum = 0, res = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int num : nums){
            currSum+=num;
            int compliment = currSum - target;
            res+=map.getOrDefault(compliment, 0);

            map.put(currSum, map.getOrDefault(currSum,0)+1);
        }

        return res;
    }
}
