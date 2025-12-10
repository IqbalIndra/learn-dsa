package com.testing.learndsa.arrays;

import java.util.Arrays;
import java.util.stream.Stream;

public class MoveZero {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0){
                nums[index] = nums[i];
                index++;
            }
        }

        Arrays.stream(nums)
                .forEach(System.out::println);

    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        MoveZero moveZero = new MoveZero();
        moveZero.moveZeroes(nums);
    }
}
