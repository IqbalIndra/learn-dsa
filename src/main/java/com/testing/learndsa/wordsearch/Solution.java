package com.testing.learndsa.wordsearch;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'cari' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY huruf
     *  2. STRING_ARRAY kata
     */

    private static final int[] DIR_X = {0, 1, 1};  // arah horizontal, vertikal, dan diagonal
    private static final int[] DIR_Y = {1, 0, 1};


    public static List<String> cari(List<String> huruf, List<String> kata) {
        List<String> arr = new ArrayList<>();
        char[][] chars = new char[huruf.size()][];

        for (int i = 0; i < huruf.size(); i++) {
            chars[i] = huruf.get(i).toCharArray();
        }

        for (int i = 0; i < kata.size(); i++) {
            boolean ketemu = cariByKata(chars,kata.get(i));
            if(ketemu) {
                arr.add("YA");
            }else {
                arr.add("TIDAK");
            }
        }

        return arr;
    }

    static boolean cariByKata(char[][] chars,String kata){
        int m = chars.length;
        int n = chars[0].length;

        boolean result = false;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (chars[i][j] == kata.charAt(0)) {
                    result = backtrack(chars, kata, i, j, 0);
                    if (result)return true;
                }
            }
        }

        return false;
    }

    static void print(char[][] chars){
        for (char[] char1D : chars) {
            for (char c : char1D)
                System.out.print(c + " ");

            System.out.println();
        }
    }

    private static boolean backtrack(char[][] chars, String kata, int i, int j, int index) {
        if (index == kata.length()) {
            return true;
        }

        if (i < 0 || i >= chars.length || j < 0 || j >= chars[0].length  || chars[i][j] != kata.charAt(index)) {
            return false;
        }

        char temp = chars[i][j];
        chars[i][j] = '#';  // Mark the cell as visited

        /*for (int dir = 0; dir < 3; dir++) {
            int newX = i + DIR_X[dir];
            int newY = j + DIR_Y[dir];
            if (backtrack(chars, kata, newX, newY, index + 1)) {
                return true;
            }
        }*/

        if (backtrack(chars, kata, i, j+1, index + 1)) {
            return true;
        }

        chars[i][j] = temp;  // Unmark the cell
        return false;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int B = Integer.parseInt(firstMultipleInput[0]);

        int K = Integer.parseInt(firstMultipleInput[1]);

        List<String> huruf = IntStream.range(0, B).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> kata = IntStream.range(0, T).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        List<String> result = Result.cari(huruf, kata);

        result.stream().forEach(System.out::println);

        bufferedReader.close();

    }
}
