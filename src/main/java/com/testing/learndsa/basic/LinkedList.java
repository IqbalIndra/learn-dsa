package com.testing.learndsa.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LinkedList {
    private Node head;
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
        length = 1;
    }

    public void printList(){
        Node node = getHead();
        while(node != null){
            System.out.println(node.value);
            node = node.next;
        }
    }

    public void clearAll(){
        head = null;
        length = 0;
    }

    public void append(int value){
        Node newNode = new Node(value);
        if(length == 0){
            head = newNode;
        }else{
            Node temp = getHead();
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }

        length++;
    }

    /*
    * 1->9->3
    * n c p
    * */

    public Node reverse(Node head){
        Node next = null, curr = head, prev = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    //1->9->
    //0->1->
    public Node addSum(Node head1, Node head2){
        head1 = reverse(head1);
        head2 = reverse(head2);

        Node res = null;

        int carry = 0;
        while(head1 != null || head2 != null || carry > 0){
            int sum = carry;
            if(head1!= null){
                sum+=head1.value;
                head1 = head1.next;
            }
            if(head2 != null){
                sum+=head2.value;
                head2 = head2.next;
            }
            carry = sum / 10;
            Node newNode = new Node(sum % 10);
            newNode.next = res;
            res = newNode;
        }

        while(res != null && res.value == 0){
            res = res.next;
        }
        return res == null ? new Node(0) : res;
    }


    public Node getHead() {
        return head;
    }


    public int getLength() {
        return length;
    }
}
