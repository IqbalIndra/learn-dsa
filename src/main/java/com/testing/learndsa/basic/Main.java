package com.testing.learndsa.basic;

public class Main {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList(5);
        doubleLinkedList.append(6);
        System.out.println(doubleLinkedList.removeLast().val);
        System.out.println(doubleLinkedList.removeLast().val);
        System.out.println(doubleLinkedList.removeLast());
        doubleLinkedList.printList();
    }
}
