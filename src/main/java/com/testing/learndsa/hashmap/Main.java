package com.testing.learndsa.hashmap;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.subarraySum(new int[]{1, 2, 3, 4, 5}, 9);
        System.out.println(Arrays.toString(res));
    }
}
