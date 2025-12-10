/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testing.learndsa.binarytree;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author xhu
 */
public class MemoManager<E extends Comparable> {
    
    public BinaryTree bTreeDate;
    public BinaryTree bTreeTitle;


    public MemoManager() {
        bTreeDate = new BinaryTree<E,Date>();
        bTreeTitle = new BinaryTree<E,String>();
    }
    
    
    public void addMemo(String date, String title, String message)
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Memo memo = new Memo();
        try {
            //converting a string to date
            memo.date = dateFormat.parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(MemoManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        memo.title = title;
        memo.message = message;
        addToTree(memo, (E) memo.date);
        addToTree(memo, (E) memo.title);
    }
    
    public void addToTree(Memo memo, E key)
    {        
        if(key instanceof Date){
            bTreeDate.addElement(memo,key);
        }else if(key instanceof String){
            bTreeTitle.addElement(memo,key);
        }
    }
    
    public Memo findMemo(E key)
    {
        if(key instanceof Date){
            return (Memo) bTreeDate.searchElement(key);
        }else if(key instanceof String){
            return (Memo) bTreeTitle.searchElement(key);
        }
        return null;
    }
    
    public Memo[] getSortedMemoList(E key)
    {
        Node[] nodes = null;

        if(key instanceof Date){
            nodes = bTreeDate.toSortedList();
        }else if(key instanceof String){
            nodes = bTreeTitle.toSortedList();
        }
        if(nodes.length > 0){
            Memo[] memos = new Memo[nodes.length];
            for(int i=0; i< nodes.length; i++) {
                memos[i] = (Memo) nodes[i].element;
            }
            return memos;
        }

        return null;
    }
    
    public void reverseOrder()
    {
        bTreeDate.reverseOrder();
        bTreeTitle.reverseOrder();
    }    
}
