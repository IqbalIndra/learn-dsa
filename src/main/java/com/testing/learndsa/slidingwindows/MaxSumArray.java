package com.testing.learndsa.slidingwindows;

/**
 * find the max sum array of fixed size K
 *
 * example input :
 * [4,2,1,7,8,1,2,8,1,0] , K = 3
 * */
public class MaxSumArray {
    public static int findMaxSumArray(int[] arr, int k){
        int maxValue = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int i = 0; i < arr.length; i++) {
            currentSum+=arr[i];
            if(i>=(k-1)){
                maxValue = Math.max(maxValue, currentSum);
                currentSum-=arr[i - (k-1)];
            }
        }
        return maxValue;
    }
    public static void main(String[] args) {
        System.out.println(findMaxSumArray(new int[]{4,2,1,7,8,1,2,8,1,0} , 3));
    }
}
