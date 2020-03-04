/**
 * Created by xuanmao on 2020/2/18.
 */
public class leetcode427 {

    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {}

        public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    }

    public Node construct(int[][] grid) {
        Node root = new Node();
        if (grid.length==1){
            root.isLeaf = true;
            root.val = grid[0][0]!=0;
            return root;
        }
        int n = grid.length/2;
        int[][] a = new int[n][n];
        int[][] b = new int[n][n];
        int[][] c = new int[n][n];
        int[][] d = new int[n][n];
        for (int i =0;i<n;i++){
            for (int j=0;j<n;j++){
                a[i][j] = grid[i][j];
                b[i][j] = grid[i+n][j];
                c[i][j] = grid[i][j+n];
                d[i][j] = grid[i+n][j+n];
            }
        }
        root.topLeft = construct(a);
        root.topRight = construct(c);
        root.bottomLeft = construct(b);
        root.bottomRight = construct(d);
        if (root.topLeft.isLeaf && root.topRight.isLeaf && root.bottomLeft.isLeaf && root.bottomRight.isLeaf){
            if ((root.topLeft.val == root.topRight.val) && (root.topLeft.val == root.bottomRight.val) && (root.topLeft.val == root.bottomLeft.val)){
                root.isLeaf = true;
                root.val = root.topLeft.val;
                root.topLeft = null;
                root.topRight = null;
                root.bottomLeft = null;
                root.bottomRight = null;
            }
        }
        return root;
    }
}
