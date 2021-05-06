import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by xuanmao on 2021/3/23.
 */
public class leetcode341 {

    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    public class NestedIterator implements Iterator<Integer> {

        List<Integer> value = new ArrayList<>();
        Integer index= 0;

        public NestedIterator(List<NestedInteger> nestedList) {
            dfs(nestedList);
        }

        @Override
        public Integer next() {
            if (!hasNext()){
                return null;
            }
            return value.get(index++);
        }

        @Override
        public boolean hasNext() {
            return index < value.size();
        }

        private void dfs(List<NestedInteger> nestedList){
            for (NestedInteger nestedInteger:nestedList){
                if (nestedInteger.isInteger()){
                    value.add(nestedInteger.getInteger());
                } else {
                    dfs(nestedInteger.getList());
                }
            }
        }
    }


}
