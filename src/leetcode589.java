import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by xuanmao on 2019/12/27.
 */
public class leetcode589 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> preorder(Node root) {
        if (root==null){
            return new ArrayList<>();
        }
        Stack<Node> nodeStack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        nodeStack.add(root);
        while (!nodeStack.isEmpty()){
            Node nowNode=  nodeStack.pop();
            ans.add(nowNode.val);
            for(int i= nowNode.children.size()-1; i>=0;i--){
                nodeStack.add(nowNode.children.get(i));
            }
        }
        return ans;
    }
}
