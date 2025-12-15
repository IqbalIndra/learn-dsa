package com.testing.learndsa.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;

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
    //1->2->3->1->4->2->1->
    //                     R
    //            S
    //1->2->3->4->2->1->

    public void removeDuplicate(){
        Set<Integer> unique = new HashSet<>();

        Node runner = getHead();
        Node slow = null;

        while(runner != null){
            if(unique.contains(runner.value)){
                slow.next = runner.next;
            }else{
                unique.add(runner.value);
                slow = runner;
            }
            runner = runner.next;

        }


    }

    public int binaryToDecimal(){
        Node curr = getHead();
        int num = 0;
        while(curr != null ){
            num= (2*num) + curr.value;
            curr = curr.next;
        }

        return num;
    }


    public void partitionList(int x){
        Node curr = getHead();
        Node greaterNodes = new Node(0);
        Node lessNodes = new Node(0);
        Node temp1 = greaterNodes;
        Node temp2 = lessNodes;
        while(curr != null){
            if(curr.value >= x){
                temp1.next = curr;
                temp1 = curr;
            }else{
                temp2.next = curr;
                temp2 = curr;
            }
            curr = curr.next;
        }

        temp1.next = null;
        temp2.next = greaterNodes.next;
        head = lessNodes.next;
    }

    private Node getAppendNode(Node nodes, Node newNode) {
        if(nodes == null){
            nodes = newNode;
        }else{
            Node temp = nodes;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
        return nodes;
    }

    public Node findKthFromEnd(int k){
        if(k <= 0) return null;

        Node fast = getHead();
        Node slow = getHead();

        //          s
        //                f
        // 1->2->3->4->5->
        for (int i = 0; i <k; i++) {
            if(fast == null)
                return null;
            fast = fast.next;
        }

        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public void reverse(){
        Node temp = getHead();
        head = tail;
        tail = temp;

        Node before = null;
        Node after;

        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }

    }

    /*
        4->3->2->null
        F
        S
              F
           S
     */
    public Node findMiddle(){
        Node fast = getHead();
        Node slow = getHead();

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public boolean hasLoop(){
        Node fast = getHead();
        Node slow = getHead();

        while(fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast)
                return true;
        }
        return false;
    }

    //1->2->3
    //0->1->2
    //1->4->2->3
    public boolean insert(int index, int value){
        if(index < 0 || index >= length)
            return false;

        if(index == 0){
            prepend(value);
        }else if(index == length-1) {
            append(value);
        }else{
            Node temp = get(index-1);
            Node newNode = new Node(value);

            Node nextNode = temp.next;
            temp.next = newNode;
            newNode.next = nextNode;
            length++;
        }

        return true;
    }

    //4->3->2
    //0->1->2
    public boolean set(int index, int value){
        Node temp = get(index);
        if(temp == null)
            return false;
        temp.value = value;
        return true;
    }

    //4->3->2
    //0->1->2
    public Node get(int index){
        if(index < 0 || index >= length)
            return null;

        Node curr = getHead();
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr;
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
