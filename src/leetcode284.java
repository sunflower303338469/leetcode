import java.util.Iterator;

/**
 * Created by xuanmao on 2019/2/11.
 */
public class leetcode284 {
    class PeekingIterator implements Iterator<Integer> {

        private Integer temp;
        private Iterator<Integer> iterator;
        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            this.iterator = iterator;
            if (this.iterator.hasNext()){
                temp = this.iterator.next();
            }
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            if (null == temp){
                return -100000;
            }
            return temp;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            if (null == temp){
                return -100000;
            }
            Integer re = temp;
            if (iterator.hasNext()){
                temp = iterator.next();
            } else {
                temp = null;
            }
            return re;
        }

        @Override
        public boolean hasNext() {
            return !(temp == null);
        }
    }
}
