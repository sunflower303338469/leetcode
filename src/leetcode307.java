/**
 * Created by xuanmao on 2020/4/9.
 */
public class leetcode307 {
    class NumArray {

        int n;
        //注意 0不放数
        int[] a;   //原数组
        int[] c;   //树状数组

        /**
         * 计算lowbit
         * c[x] = a[x-lowbit(x)+1] 到 a[x] 的和
         * lowbit本质为x的最大的 2的k次方公约数
         *
         * @param x
         * @return
         */
        private int lowbit(int x) {
            return x & (-x);
        }

        /**
         * 计算1-i的值
         * 因为 c[i] = sum(a[i-lowbit(i)+1) ,a[i])
         * 所以 每次加上c[i]  然后让 i = i-lowbit(i) 即再去加前面的和
         */
        public int getSum(int i) {
            int sum = 0;
            while (i > 0) {
                sum = sum + c[i];
                i = i - lowbit(i);
            }
            return sum;
        }

        /**
         * a[i]的增加value
         * 更新c[i]
         *
         * @param i
         * @param value
         * @return
         */
        public void add(int i, int value) {
            while (i <= n) {
                c[i] += value;
                i = i + lowbit(i);
            }
        }

        public NumArray(int[] nums) {
            n = nums.length;
            a = new int[n+1];
            c = new int[n+1];
            for (int i =0;i<n;i++){
                a[i+1] = nums[i];
                add(i+1, a[i+1]);
            }
        }

        public void update(int i, int val) {
            int cha = val - a[i+1];
            a[i+1] = val;
            add(i+1, cha);
        }

        public int sumRange(int i, int j) {
            return getSum(j+1) - getSum(i);
        }
    }
}
