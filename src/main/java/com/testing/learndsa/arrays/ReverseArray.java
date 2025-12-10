package com.testing.learndsa.arrays;

import java.util.Arrays;

public class ReverseArray {

    public int[] reverse(int[] arrays, int start, int end) {
        while(start<end){
            int temp = arrays[start];
            arrays[start] = arrays[end];
            arrays[end] = temp;
            start++;
            end--;
        }
        return arrays;
    }

    public static void main(String[] args) {
        int arrays[] = {2,11,0,3,9};
        ReverseArray reverseArray = new ReverseArray();
        System.out.println(Arrays.toString(reverseArray.reverse(arrays, 0, arrays.length - 1)));
    }
}
