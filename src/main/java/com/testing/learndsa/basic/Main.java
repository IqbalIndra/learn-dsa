package com.testing.learndsa.basic;

public class Main {
    public static void main(String[] args) {
        LRUCache lru = new LRUCache(2);
        lru.put(1,1);
        System.out.println(lru.get(1));
        lru.put(2,2);
        lru.put(3,3);
        lru.put(4,4);
        lru.print();
        System.out.println(lru.get(2));
        System.out.println(lru.get(1));
        lru.put(3,8);
        lru.print();

    }
}
