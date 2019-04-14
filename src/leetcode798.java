/**
 * Created by xuanmao on 2019/2/24.
 */
public class leetcode798 {
    public int bestRotation(int[] A) {
        SegmentTree segmentTree = new SegmentTree(A.length);
        for (int i = 0; i < A.length; i++) {
            if ((A[i] < A.length) && (i + 1 < A.length)) {
                int end = A.length - 1;
                if (end > i + 1 + (A.length - 1 - A[i])) {
                    end = i + 1 + (A.length - 1 - A[i]);
                }
                System.out.println((i + 1) + " " + end + " " + 1);
                segmentTree.setValue(i + 1, end, 1);
            }
            if (i >= A[i]) {
                System.out.println(0 + " " + (i - A[i]) + " " + 1);
                segmentTree.setValue(0, i - A[i], 1);
            }
        }
        int max = 0;
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            int val = segmentTree.getVal(i);
            if (max < val) {
                max = val;
                ans = i;
            }
        }
        return ans;
    }

    private class Node {
        public int lBorder;
        public int rBorder;
        public int val;
        public Node left;
        public Node right;
    }

    private class SegmentTree {
        private Node root;

        public SegmentTree(int n) {
            root = buildTree(0, n - 1);
        }

        public void setValue(int l, int r, int val) {
            segTreeSet(root, l, r, val);
        }

        public int getVal(int x) {
            return segTreeGet(root, x);
        }

        private Node buildTree(int l, int r) {
            Node node = new Node();
            node.val = 0;
            node.lBorder = l;
            node.rBorder = r;
            if (l == r) {
                return node;
            }
            int mid = (node.rBorder + node.lBorder) / 2;
            node.left = buildTree(l, mid);
            node.right = buildTree(mid + 1, r);
            return node;
        }

        private int segTreeGet(Node root, int x) {
            if ((root.lBorder == root.rBorder) && (root.lBorder == x)) {
                return root.val;
            }
            int mid = (root.rBorder + root.lBorder) / 2;
            root.left.val += root.val;
            root.right.val += root.val;
            root.val = 0;
            if (x <= mid) {
                return segTreeGet(root.left, x);
            } else {
                return segTreeGet(root.right, x);
            }
        }

        private void segTreeSet(Node root, int l, int r, int val) {
            if (root.lBorder == l && root.rBorder == r) {
                root.val += val;
                return;
            }
            int mid = (root.rBorder + root.lBorder) / 2;
            if (r <= mid) {
                segTreeSet(root.left, l, r, val);
                return;
            }
            if (l > mid) {
                segTreeSet(root.right, l, r, val);
                return;
            }
            segTreeSet(root.left, l, mid, val);
            segTreeSet(root.right, mid + 1, r, val);
        }
    }
}
