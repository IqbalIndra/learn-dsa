package com.testing.learndsa.basic;

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
