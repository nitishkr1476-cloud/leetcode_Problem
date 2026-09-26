class MyHashSet {

    private static final int SIZE = 1009;
    private Node[] buckets;

    class Node {
        int key;
        Node next;

        Node(int key) {
            this.key = key;
        }
    }

    public MyHashSet() {
        buckets = new Node[SIZE];
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void add(int key) {
        int index = hash(key);

        Node curr = buckets[index];

        // Already exists
        while (curr != null) {
            if (curr.key == key) {
                return;
            }
            curr = curr.next;
        }

        // Add new node at beginning
        Node newNode = new Node(key);
        newNode.next = buckets[index];
        buckets[index] = newNode;
    }

    public void remove(int key) {
        int index = hash(key);

        Node curr = buckets[index];
        Node prev = null;

        while (curr != null) {
            if (curr.key == key) {

                if (prev == null) {
                    buckets[index] = curr.next;
                } else {
                    prev.next = curr.next;
                }

                return;
            }

            prev = curr;
            curr = curr.next;
        }
    }

    public boolean contains(int key) {
        int index = hash(key);

        Node curr = buckets[index];

        while (curr != null) {
            if (curr.key == key) {
                return true;
            }
            curr = curr.next;
        }

        return false;
    }
}