package com.testing.learndsa.basic;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    private Node head;
    private Node tail;
    private final int capacity;
    private Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }

    class Node{
        int key;
        int val;
        Node next;
        Node prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        @Override
        public String toString() {
            return "{"+key+"="+val+"}";
        }
    }

    public void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp);
            temp = temp.next;
        }
        System.out.println();
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        remove(node);
        insert(node);
        return node.val;
    }


    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node temp = map.get(key);
            temp.val = value;
            remove(temp);
            insert(temp);
        }else{
            Node newNode = new Node(key,value);

            if(map.size() == capacity){
                Node remove = removeLast();
                if(remove!=null) map.remove(remove.key);
            }
            insert(newNode);
            map.put(key, newNode);
        }
    }

    private void insert(Node newNode) {
        newNode.next = head.next;
        newNode.prev = head;
        head.next.prev = newNode;
        head.next = newNode;
    }

    private void remove(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    private Node removeLast(){
        if(tail.prev == head) return null;
        Node remove = tail.prev;
        remove(remove);
        return remove;
    }
}