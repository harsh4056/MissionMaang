package tools;

class IntHashSet {
    private int[] table;
    private boolean[] used;
    private int size;
    private int capacity;
    private final double LOAD_FACTOR = 0.75;

    public IntHashSet() {
        this.capacity = 1024;
        this.table = new int[capacity];
        this.used = new boolean[capacity];
        this.size = 0;
    }

    private int hash(int key) {
        return (key % capacity + capacity) % capacity;
    }

    public boolean add(int key) {
        if (contains(key)) return false;

        if ((double) size / capacity >= LOAD_FACTOR) {
            resize();
        }

        int h = hash(key);
        int i = 0;
        while (used[h]) {
            i++;
            h = (h + i * i) % capacity;
        }
        table[h] = key;
        used[h] = true;
        size++;
        return true;
    }

    public boolean contains(int key) {
        int h = hash(key);
        int i = 0;
        while (used[h]) {
            if (table[h] == key) return true;
            i++;
            h = (h + i * i) % capacity;
        }
        return false;
    }

    private void resize() {
        int oldCapacity = capacity;
        capacity *= 2;
        int[] oldTable = table;
        boolean[] oldUsed = used;

        table = new int[capacity];
        used = new boolean[capacity];
        size = 0;

        for (int i = 0; i < oldCapacity; i++) {
            if (oldUsed[i]) {
                add(oldTable[i]);
            }
        }
    }
}
