/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testing.learndsa.binarytree;

/**
 *
 * @author xhu
 */
public class BinaryTree <E, F extends Comparable> {

    public Node root;
    public Node[] nodeList;

    public int number_of_nodes = 0;

    private boolean is_reverse_order = false;

    public BinaryTree(Node node)
    {

    }
    
    public BinaryTree(E element, F key)
    {

    }
    
    public BinaryTree()
    {
        this.root = null;
    }
    
    public void addElement(E element, F key)
    {
        Node node = new Node(element,key);
        addNode(root,node);
        number_of_nodes++;
    }
    
    public void addNode(Node root, Node node)
    {
        this.root = addRecursive(root, node);
    }

    private Node addRecursive(Node current, Node node) {
        if(current == null)
            return node;

        if (current.compareTo(node) < 0) {
            current.l_node = addRecursive(current.l_node, node);
        } else if (current.compareTo(node) > 0) {
            current.r_node = addRecursive(current.r_node, node);
        } else {
            return current;
        }

        return current;
    }
    
    //for your debugging
    public void traversal(Node root)
    {
        if (!is_reverse_order) {
            inOrder(root);
        }else{
            reverseOrder(root);
        }
    }

    
    public Node[] toSortedList()
    {
        toSortedList(this.root);
        return nodeList;
    }
    
    private void toSortedList(Node root)
    {
        nodeList = new Node[number_of_nodes];
        if(!is_reverse_order)
            fillNodeListInOrder(root,nodeList,0);
        else
            fillNodeListReverseOrder(root,nodeList,0);
    }

    private int fillNodeListInOrder(Node root, Node[] nodeList, int i) {
        if(root.l_node != null){
            i = fillNodeListInOrder(root.l_node,nodeList,i);
        }
        nodeList[i++] = root;
        if(root.r_node != null){
            i = fillNodeListInOrder(root.r_node,nodeList,i);
        }
        return i;
    }

    private int fillNodeListReverseOrder(Node root, Node[] nodeList, int i) {
        if(root.r_node != null){
            i = fillNodeListReverseOrder(root.r_node,nodeList,i);
        }
        nodeList[i++] = root;
        if(root.l_node != null){
            i = fillNodeListReverseOrder(root.l_node,nodeList,i);
        }
        return i;
    }

    public E searchElement(F key)
    {
        Node node = searchNode(this.root , new Node(null,key));
        return node != null ? (E) node.element : null ;
    }
       
    public Node searchNode(Node root, Node node)
    {
        if(root == null)
            return null;

        if (root.compareTo(node) < 0) {
            return searchNode(root.l_node, node);
        } else if (root.compareTo(node) > 0) {
            return searchNode(root.r_node, node);
        } else {
            return root;
        }
    }
    
    public void reverseOrder()
    {
        is_reverse_order = true;
    }
    
    private void reverseOrder(Node root)
    {
        if (root != null) {
            reverseOrder(root.r_node);
            System.out.println("##" + root.element);
            reverseOrder(root.l_node);
        }
    }

    private void inOrder(Node root){
        if(root != null){
            inOrder(root.l_node);
            System.out.print("##" + root.element);
            inOrder(root.r_node);
        }
    }
       
}
