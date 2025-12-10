package com.testing.learndsa.frog;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read number of test cases
        int T = scanner.nextInt();

        for (int t = 0; t < T; t++) {
            // Read N and K
            int N = scanner.nextInt();
            int K = scanner.nextInt();

            // Read the heights of the pillars
            int[] A = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = scanner.nextInt();
            }

            // Read the starting heights for each day
            int[] B = new int[K];
            for (int i = 0; i < K; i++) {
                B[i] = scanner.nextInt();
            }

            int totalJumps = 0;

            for (int i = 0; i < K; i++) {
                int startHeight = B[i];
                int jumps = 0;

                // Find the leftmost pillar from which Flapjack can start
                int startPos = -1;
                for (int j = 0; j < N; j++) {
                    if (A[j] <= startHeight) {
                        startPos = j;
                        break;
                    }
                }

                if (startPos != -1) {
                    // Calculate the maximum number of jumps starting from startPos
                    int currentHeight = A[startPos];
                    for (int j = startPos + 1; j < N; j++) {
                        if (A[j] > currentHeight) {
                            currentHeight = A[j];
                            jumps++;
                        }
                    }
                }

                totalJumps += jumps;
            }

            System.out.println(totalJumps);
        }

        scanner.close();
    }
}
