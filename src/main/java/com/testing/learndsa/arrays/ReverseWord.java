package com.testing.learndsa.arrays;

public class ReverseWord {

    public String reverseWords(String s) {
        s = s.trim();
        String[] words = s.split(" ");

        StringBuilder result = new StringBuilder();
        for (int i = words.length-1; i >=0; i--) {
            result.append(words[i]);
            if(i != 0)
                result.append(" ");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        ReverseWord reverseWord = new ReverseWord();
        System.out.println(reverseWord.reverseWords("a good   example"));

    }
}
