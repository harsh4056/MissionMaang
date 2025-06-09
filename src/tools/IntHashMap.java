package tools;

class IntHashMap {
    private int[] keys;
    private int[] values;
    private boolean[] used;
    private int size;
    private int capacity;
    private final double LOAD_FACTOR = 0.75;

    public IntHashMap() {
        this.capacity = 1024;
        this.keys = new int[capacity];
        this.values = new int[capacity];
        this.used = new boolean[capacity];
        this.size = 0;
    }

    private int hash(int key) {
        return (key % capacity + capacity) % capacity;
    }

    public void put(int key, int value) {
        if ((double) size / capacity >= LOAD_FACTOR) {
            resize();
        }
        int h = hash(key);
        int i = 0;
        while (used[h]) {
            if (keys[h] == key) {
                values[h] = value;
                return;
            }
            i++;
            h = (h + i * i) % capacity;
        }
        keys[h] = key;
        values[h] = value;
        used[h] = true;
        size++;
    }

    public int get(int key) {
        int h = hash(key);
        int i = 0;
        while (used[h]) {
            if (keys[h] == key) return values[h];
            i++;
            h = (h + i * i) % capacity;
        }
        return 0; // or any default you want
    }

    public boolean containsKey(int key) {
        int h = hash(key);
        int i = 0;
        while (used[h]) {
            if (keys[h] == key) return true;
            i++;
            h = (h + i * i) % capacity;
        }
        return false;
    }

    private void resize() {
        int oldCapacity = capacity;
        capacity *= 2;
        int[] oldKeys = keys;
        int[] oldValues = values;
        boolean[] oldUsed = used;

        keys = new int[capacity];
        values = new int[capacity];
        used = new boolean[capacity];
        size = 0;

        for (int i = 0; i < oldCapacity; i++) {
            if (oldUsed[i]) {
                put(oldKeys[i], oldValues[i]);
            }
        }
    }
}

