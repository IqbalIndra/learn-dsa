package com.testing.learndsa.binarytree;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Memo memo = new Memo();
        memo.date = stringToDate("2024/12/07");
        memo.title = "Testing";
        memo.message = "wkwkkw";

        BinaryTree<Memo,Date> bts = new BinaryTree<>();
        bts.addElement(memo,memo.date);

        memo = new Memo();
        memo.date = stringToDate("2024/4/08");
        memo.title = "Testing";
        memo.message = "wkwkkw";
        bts.addElement(memo,memo.date);

        memo = new Memo();
        memo.date = stringToDate("2024/1/08");
        memo.title = "Testing";
        memo.message = "wkwkkw";

        bts.addElement(memo,memo.date);

        memo = new Memo();
        memo.date = stringToDate("2024/10/13");
        memo.title = "Testing";
        memo.message = "wkwkkw";

        bts.addElement(memo,memo.date);
        bts.reverseOrder();
        Arrays.stream(bts.toSortedList())
                .forEach(node -> System.out.println(node.element));
    }


    public static Date stringToDate(String stDdate){
        Date date = null;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        try
        {
            date = dateFormat.parse(stDdate);
        }
        catch (ParseException ex)
        {
            System.out.println(ex);
        }
        return date;
    }
}
