/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testing.learndsa.binarytree;

import java.util.Date;

/**
 *
 * @author xhu
 */
public class Node <E, F extends Comparable> implements Comparable <Node>{
    public E element;
    public F key;

    public Node<E,F> l_node,r_node;

    public Node(E element, F key) {
        this.element = element;
        this.key = key;
        l_node = null;
        r_node = null;
    }

    @Override
    public int compareTo(Node t) {
        if(t.key instanceof Date){
            Date date = (Date) t.key;
            return date.compareTo((Date) key);
        }else if(t.key instanceof String){
            String title = (String) t.key;
            return title.compareTo((String) key);
        }
        return 0;
    }
}
