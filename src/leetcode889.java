/**
 * Created by xuanmao on 2019/6/12.
 */
public class leetcode889 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int[] place;

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        TreeNode head = new TreeNode(pre[0]);
        place = new int[post.length+1];
        for (int i = 0; i < post.length; i++) {
            place[post[i]] = i;
        }
        for (int i = 1; i < pre.length; i++) {
            setPlace(pre[i], head);
        }
        return head;
    }

    private boolean setPlace(int x, TreeNode head) {
        if (place[head.val] < place[x]) {
            return false;
        }
        if (head.left == null) {
            TreeNode newNode = new TreeNode(x);
            head.left = newNode;
            return true;
        }
        if ((head.right == null) && (place[head.left.val] < place[x])) {
            TreeNode newNode = new TreeNode(x);
            head.right = newNode;
            return true;
        }
        if (setPlace(x, head.left)) {
            return true;
        }
        return setPlace(x, head.right);
    }
}
