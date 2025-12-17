package com.testing.learndsa.basic;

public class DoubleLinkedList {
    private Node head;
    private Node tail;
    private int length;

    public DoubleLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    class Node{
        int val;
        Node next;
        Node prev;

        public Node(int val) {
            this.val = val;
        }
    }


    public void append(int val){
        Node newNode = new Node(val);
        if(length ==0){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        length++;
    }

    //1->2->
    //3<->1->2
    public void prepend(int val){
        Node newNode = new Node(val);
        if(length ==0){
            head = newNode;
            tail = newNode;
        }else{
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node removeLast(){
        if(length == 0) return null;
        Node temp = getTail();

        if(length == 1){
            head = null;
            tail = null;
        }else{
            tail = temp.prev;
            tail.next = null;
            temp.prev = null;
        }
        length--;
        return temp;
    }
    //1<->2<->
    public Node removeFirst(){
        if(length == 0) return null;
        Node temp = getHead();

        if(length == 1){
            head = null;
            tail = null;
        }else{
            head = temp.next;
            temp.next = null;
            head.prev = null;
        }

        length--;
        return temp;

    }

    public void printList(){
        Node head = getHead();
        while(head != null){
            System.out.print(head.val+"->");
            head = head.next;
        }
        System.out.println();
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }
}
