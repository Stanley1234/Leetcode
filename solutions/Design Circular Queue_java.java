class MyCircularQueue {

    /**
     * Invariant:
     * 1. If the ring buffer is empty, then head == tail
     * 2. If the ring buffer is not empty, head references to the head of ring buffer, and tail references to the          tail of ring buffer
     */
    
    private int[] buffer;
    private int head;
    private int tail;
    
    private int size;
    private int capacity;
    
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        capacity = k;
        buffer = new int[k];
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        if (!isEmpty()) {
            tail = (tail + 1) % capacity;
        } 
        buffer[tail] = value;
        size ++;
        return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        if (head != tail) {
            head ++;   
        }
        size --;
        return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        return isEmpty() ? -1 : buffer[head];
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        return isEmpty() ? -1 : buffer[tail];
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */