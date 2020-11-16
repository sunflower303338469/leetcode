/**
 * Created by xuanmao on 2020/9/3.
 */
public class leetcode622 {
    class MyCircularQueue {

        int frontIndex = 0;
        int endIndex = -1;
        int[] queue;
        int capacity;
        int num = 0;

        /**
         * Initialize your data structure here. Set the size of the queue to be k.
         */
        public MyCircularQueue(int k) {
            queue = new int[k];
            capacity = k;
        }

        /**
         * Insert an element into the circular queue. Return true if the operation is successful.
         */
        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }
            num++;
            endIndex = getNext(endIndex);
            queue[endIndex] = value;
            return true;
        }

        /**
         * Delete an element from the circular queue. Return true if the operation is successful.
         */
        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }
            num--;
            frontIndex = getNext(frontIndex);
            return true;
        }

        /**
         * Get the front item from the queue.
         */
        public int Front() {
            if (isEmpty()) {
                return -1;
            }
            return queue[frontIndex];
        }

        /**
         * Get the last item from the queue.
         */
        public int Rear() {
            if (isEmpty()) {
                return -1;
            }
            return queue[endIndex];
        }

        /**
         * Checks whether the circular queue is empty or not.
         */
        public boolean isEmpty() {
            return num == 0;
        }

        /**
         * Checks whether the circular queue is full or not.
         */
        public boolean isFull() {
            System.out.println(num +" "+capacity);
            return num == capacity;
        }

        private int getNext(int index){
            return (index+1) % capacity;
        }
    }

}
