import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2019/8/8.
 */
public class leetcode297 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");

            List<TreeNode> nodelist = new ArrayList<>();
            nodelist.add(root);
            int p = 0;
            while (p<nodelist.size()){
                TreeNode now = nodelist.get(p);
                if (now!=null){
                    nodelist.add(now.left);
                    nodelist.add(now.right);
                }
                p++;
            }
            while ((!nodelist.isEmpty()) && (nodelist.get(nodelist.size()-1) == null)){
                nodelist.remove(nodelist.size()-1);
            }
            for (int i=0;i<nodelist.size();i++){
                TreeNode node = nodelist.get(i);
                if (node!=null){
                    sb.append(node.val);
                }else{
                    sb.append("null");
                }
                if (i!=nodelist.size()-1){
                    sb.append(",");
                }
            }

            sb.append("]");
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            data = data.substring(1,data.length()-1);
            String[] ss = data.split(",");
            List<TreeNode> nodelist = new ArrayList<>();
            for (int i =0;i<ss.length;i++){
                if(ss[i].equals("null")){
                    nodelist.add(null);
                } else if (!ss[i].equals("")){
                    TreeNode newNode=  new TreeNode(Integer.valueOf(ss[i]));
                    nodelist.add(newNode);
                }
            }
            int head = 0;
            int p = 1;
            while ((head<nodelist.size()) && (p<nodelist.size())){
                TreeNode now = nodelist.get(head);
                now.left = nodelist.get(p);
                if (p+1<nodelist.size()){
                    now.right = nodelist.get(p+1);
                }
                p = p+2;
                head= head+1;
                while (nodelist.get(head) ==null){
                    head = head+1;
                }
            }
            if (nodelist.isEmpty()){
                return null;
            } else {
                return nodelist.get(0);
            }
        }
    }
}
