import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2020/5/25.
 */
public class leetcode173 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class BSTIterator {

        List<Integer> list = new ArrayList<>();
        int index = 0;
        public BSTIterator(TreeNode root) {
            midOrder(root);
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            return list.get(index++);
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return list.size()>index;
        }

        private void midOrder(TreeNode root){
            if (root==null){
                return;
            }
            midOrder(root.left);
            list.add(root.val);
            midOrder(root.right);
        }
    }

}
