class MyHashSet {

   private class Entry {
        private int data;
        private Entry next;
        public Entry(int data) {
            this.data = data;
        }
    }
    
    private static final double LOAD_FACTOR = 0.75;
    
    private Entry[] data;
    
    private int length;  // length of array
    private int size;
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        length = 100000;
        data = new Entry[length];
    }
    
    public void add(int key) {
        if (contains(key)) {
            return;
        }
        addHelper(data, length, key);
        size ++;
        if (length < LOAD_FACTOR * size) {
            resize();
        }
    }
    
    public void remove(int key) {
        if (!contains(key)) {
            return;
        }
        removeHelper(data, length, key);
        size --;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        final int pos = key % length;
        
        Entry cur = data[pos];
        while (cur != null) {
            if (cur.data == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    
    private void addHelper(Entry[] storage, int length, int key) {
        final int pos = key % length;

        if (storage[pos] == null) {
            storage[pos] = new Entry(key);
            return;
        }
        
        Entry cur = storage[pos];
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new Entry(key);
    }
    
    private void removeHelper(Entry[] storage, int length, int key) {
        final int pos = key % length;
        
        if (storage[pos] != null && storage[pos].data == key) {
            storage[pos] = storage[pos].next;
            return;
        }
        
        Entry cur = storage[pos];
        while (cur.next != null) {
            if (cur.next.data == key) {
                break;
            }
        }
        cur.next = cur.next.next;
    }
    
    private void resize() {
        Entry[] oldData = data;
        Entry[] newData = new Entry[length * 2];
        for (Entry entry : oldData) {
            Entry node = entry;
            while (node != null) {
                addHelper(newData, length * 2, node.data);
                node = node.next;
            }
        }
        length *= 2;
        data = newData;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */