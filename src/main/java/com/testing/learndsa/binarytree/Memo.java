package com.testing.learndsa.binarytree;

import java.util.Date;

public class Memo {
    Date date;
    String title;
    String message;

    public String toString()
    {
        return date.toString()+"\n"+title+"\n"+message;
    }
}
