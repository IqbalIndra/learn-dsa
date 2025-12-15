package com.testing.learndsa.hashmap;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int[] subarraySum(int[] nums, int target){
        //1, 2, 3, 4, 5

        // prepopulate to hashmap {0:-1}

        // currSum= 1
        // currSum - target = 1-9 = -8
        // check {0:-1} = -8
        // {0:-1 , 1 : 0}

        // {0:-1 , 1 : 0}
        // currSum = 3
        // currSum - target = 3-9 = -6
        // check {0:-1 , 1 : 0} = -6
        // {0:-1 , 1 : 0 , 3 : 1}

        // {0:-1 , 1 : 0 , 3 : 1}
        // currSum = 6
        // currSum - target = 6-9 = -3
        // check {0:-1 , 1 : 0, 3 : 1} = -3
        // {0:-1 , 1 : 0 , 3 : 1, 6 : 2}

        // {0:-1 , 1 : 0 , 3 : 1, 6 : 2}
        // currSum = 10
        // currSum - target = 10-9 = 1
        // check {0:-1 , 1 : 0 , 3 : 1, 6 : 2} = 1
        //check (currSum - target) =0 + 1 (find in hashmap key)
        //res = res[0] = 1 , res[1] = index
        
        int currSum = 0;
        int index = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int[] res = new int[2];
        for(int num : nums){
            currSum+=num;
            int compliment = currSum - target;
            if(map.containsKey(compliment)){
                res[0] = map.get(compliment) +1;
                res[1] = index;
                break;
            }
            map.putIfAbsent(currSum, index++);
        }

        return res;
    }
}
