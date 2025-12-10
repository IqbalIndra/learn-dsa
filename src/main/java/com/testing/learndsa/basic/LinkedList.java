package com.testing.learndsa.basic;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value){
        Node node = new Node(value);
        head = node;
        tail = node;
        length = 1;
    }

    public void printList(){
        Node node = getHead();
        while(node != null){
            System.out.println(node.value);
            node = node.next;
        }
    }

    public void append(int value){
        Node newNode = new Node(value);
        if(length == 0){
            head = newNode;
        }else{
            tail.next = newNode;
        }
        tail = newNode;
        length++;
    }

    public void prepend(int value){
        Node newNode = new Node(value);
        if(length == 0){
            head = newNode;
            tail = newNode;
        }else{
            Node temp = getHead();
            head = newNode;
            head.next = temp;
        }
        length++;
    }

    //4->3->2->
    //3->2->
    public Node removeFirst(){
        if(length ==0)
            return null;

        Node curr = getHead();
        head = curr.next;
        curr.next = null;
        length--;

        if(length ==0)
            tail = null;

        return curr;
    }

    //4->3->2->
    public Node removeLast(){
        if(length == 0)
            return null;

        Node prev = getHead();
        Node curr = getHead();

        while(curr.next != null){
            prev = curr;
            curr = curr.next;
        }

        tail = prev;
        tail.next = null;
        length--;

        if(length ==0){
            head = null;
            tail = null;
        }

        return getTail();
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
