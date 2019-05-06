/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    private Integer nextValue = null;
    
    private Stack<Iterator<NestedInteger>> backtrack = new Stack<>();

    NestedIterator(List<NestedInteger> nestedInt) {
        backtrack.push(nestedInt.iterator());
        nextValue = cacheNext();
    }
    
    private Integer cacheNext() {
        if (backtrack.size() == 0) {
            return null;
        }
        
        Iterator<NestedInteger> curIter = backtrack.peek();
        
        if (curIter == null) {
            return null;    // iterate through the whole list
        }
        
        if (!curIter.hasNext()) {
            backtrack.pop();
            return cacheNext();
        }
        
        NestedInteger nextElem = curIter.next();
        if (nextElem.isInteger()) {
            return nextElem.getInteger();
        }
        
        backtrack.push(nextElem.getList().iterator());
        return cacheNext();
    }
    
    @Override
    public Integer next() {
        int result = nextValue;
        nextValue = cacheNext();
        return result;
    }
    
    @Override
    public boolean hasNext() {
        return nextValue != null;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */