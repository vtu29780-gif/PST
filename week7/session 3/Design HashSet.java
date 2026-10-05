import java.util.LinkedList;

class MyHashSet {
    private static final int BASE = 769;
    private LinkedList<Integer>[] buckets;

    @SuppressWarnings("unchecked")
    public MyHashSet() {
        buckets = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int hash(int key) {
        return key % BASE;
    }

    public void add(int key) {
        int bucketIndex = hash(key);
        if (!buckets[bucketIndex].contains(key)) {
            buckets[bucketIndex].add(key);
        }
    }

    public void remove(int key) {
        int bucketIndex = hash(key);
        buckets[bucketIndex].remove((Integer) key);
    }

    public boolean contains(int key) {
        int bucketIndex = hash(key);
        return buckets[bucketIndex].contains(key);
    }
}