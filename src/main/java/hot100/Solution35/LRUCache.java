package hot100.Solution35;

// 注意重复的问题

import java.util.*;

class Node {
    int key;
    int value;
    Node prev;
    Node next;
}

public class LRUCache {


    int maxSize;
    int currentSize;
    Node head;
    Node last;
    Map<Integer, Node> cache = new HashMap();

    public LRUCache(int capacity) {
        this.maxSize = capacity;
        this.currentSize = 0;
        head = new Node();
        last = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) return -1;
        else if (node.next == null) return node.value;
        else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = null;
            node.prev = last;
            last.next = node;
            last = node;
            return node.value;
        }

    }

    public void put(int key, int value) {
        if (cache.get(key) != null) {
            Node node = cache.get(key);
            if (node.next == null) {
                node.value = value;
                return;
            }
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = null;
            node.prev = last;
            last.next = node;
            last = node;
            cache.get(key).value = value;
            return;
        }

        Node node = new Node();
        node.key = key;
        node.value = value;
        cache.put(key, node);
        node.prev = last;
        last.next = node;
        last = node;
        currentSize++;
        if (currentSize > maxSize) {
            currentSize--;
            cache.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }

    }
}