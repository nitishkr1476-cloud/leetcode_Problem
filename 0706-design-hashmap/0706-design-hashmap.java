class MyHashMap {

    class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int SIZE = 1000;
    private Node[] buckets;

    public MyHashMap() {
        buckets = new Node[SIZE];
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int index = hash(key);

        if (buckets[index] == null) {
            buckets[index] = new Node(-1, -1); // dummy node
        }

        Node prev = find(buckets[index], key);

        if (prev.next == null) {
            prev.next = new Node(key, value);
        } else {
            prev.next.value = value;
        }
    }

    public int get(int key) {
        int index = hash(key);

        if (buckets[index] == null) {
            return -1;
        }

        Node prev = find(buckets[index], key);

        if (prev.next == null) {
            return -1;
        }

        return prev.next.value;
    }

    public void remove(int key) {
        int index = hash(key);

        if (buckets[index] == null) {
            return;
        }

        Node prev = find(buckets[index], key);

        if (prev.next != null) {
            prev.next = prev.next.next;
        }
    }

    private Node find(Node head, int key) {
        Node curr = head;
        while (curr.next != null && curr.next.key != key) {
            curr = curr.next;
        }
        return curr;
    }
}

