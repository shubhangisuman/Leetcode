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
    List<Integer> l = new ArrayList<>();
    public void helper(List<NestedInteger> nestedList,int i){
        if(i>=nestedList.size())
            return;
        NestedInteger a = nestedList.get(i);
        if(a.isInteger()){
            l.add(a.getInteger());
        }
        else{
            List<NestedInteger> arr = a.getList();
            helper(arr,0);
        }
        helper(nestedList,i+1);
    }
    public NestedIterator(List<NestedInteger> nestedList) {
        int n = nestedList.size();
        helper(nestedList,0);
        // System.out.println(l);
    }

    @Override
    public Integer next() {
        int first = l.get(0);
        l.remove(0);
        return first;
    }

    @Override
    public boolean hasNext() {
        return l.size()>0;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */