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
