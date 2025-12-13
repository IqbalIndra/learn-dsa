package com.testing.learndsa.basic;

public class Main {
    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList(1);
        linkedList.append(1);
        linkedList.append(1);
        linkedList.append(0);
        System.out.println("------");
        linkedList.printList();
        System.out.println("--Binary to Decimal----");
        System.out.println(linkedList.binaryToDecimal());
        System.out.println("------");
    }
}
