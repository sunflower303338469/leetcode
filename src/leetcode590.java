import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2019/11/12.
 */
public class leetcode590 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    List<Integer> ans = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        post(root);
        return ans;
    }

    private void post(Node root){
        if (root == null){
            return;
        }
        if ((root.children!=null) && (!root.children.isEmpty())){
            for (Node child :root.children){
                post(child);
            }
        }
        ans.add(root.val);
    }
}
