package com.testing.learndsa.caesar;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'bacaPesan' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING sandi as parameter.
     */

    public static String bacaPesan(String sandi) {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        if(sandi.length() <2 && sandi.length() >=500)
            return "";
        else if(!sandi.matches("[a-z\\s.]+")){
            return "";
        }

        char[] chars = sandi.toCharArray();
        for(char c : chars){
            int ascii = (int) c;
            if(ascii == 46)
                count++;
        }

        for(char c : chars){
            int encrypt = (int) c;
            if(encrypt != 32 && encrypt != 46){
                int a = encrypt - count;
                if(a <= 96){
                    a = 122 - (count - (encrypt - 96));
                }
                char decrypt = (char) (a);
                sb.append(decrypt);
            }else if(encrypt == 32){
                sb.append(" ");
            }
        }

        return sb.toString();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {

        String sandi = "xj..wfsl in. bfpyz kfo.fw ijslfs pjpzfy.fs ujsze";
        String pesan = Result.bacaPesan(sandi);
        System.out.println(pesan);

    }
}
