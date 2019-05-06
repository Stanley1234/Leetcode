class MinStack {

    private class Node {
        int minSoFar;
        int data;
        Node down;
        public Node(int data) {
            this.data = data;
        }
    }
    
    Node top;
    
    /** initialize your data structure here. */
    public MinStack() {}

    
    public void push(int x) {
        Node newNode = new Node(x);
        newNode.down = top;
        if (top != null) {
            newNode.minSoFar = Math.min(x, top.minSoFar);
        } else {
            newNode.minSoFar = x;
        }
        top = newNode;
    }
    
    public void pop() {
        if (top != null) {
            top = top.down;
        }
    }
    
    public int top() {
        return top.data;
    }
    
    public int getMin() {
        return top.minSoFar;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */