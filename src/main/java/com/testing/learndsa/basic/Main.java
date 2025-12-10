package com.testing.learndsa.basic;

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.prepend(4);
        linkedList.removeFirst();
        linkedList.removeFirst();
        linkedList.removeFirst();
        linkedList.removeFirst();
        System.out.println(linkedList.removeFirst());
        linkedList.printList();
    }
}
