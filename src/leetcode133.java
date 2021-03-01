import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by xuanmao on 2021/1/17.
 */
public class leetcode133 {
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    Map<Node,Node> nodeMap = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null){
            return null;
        }
        List<Node> vis = new ArrayList<>();
        vis.add(node);
        cloneNode(node);
        int l = 0;
        while (l<vis.size()){
            Node now = vis.get(l);
            for (Node n:now.neighbors){
                if (!nodeMap.containsKey(n)){
                    vis.add(n);
                    cloneNode(n);
                }
            }
            l++;
        }
        for (Node oldNode:vis){
            Node newNode = nodeMap.get(oldNode);
            for (Node n:oldNode.neighbors){
                newNode.neighbors.add(nodeMap.get(n));
            }
        }
        return nodeMap.get(node);
    }

    private void cloneNode(Node oldNode){
        nodeMap.put(oldNode, new Node(oldNode.val));
    }
}
