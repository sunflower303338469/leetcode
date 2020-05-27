import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by xuanmao on 2020/4/12.
 */
public class leetcode865 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    List<TreeNode> nowList = new ArrayList<>();
    List<TreeNode> ansList;
    int max = -1;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root==null){
            return null;
        }
        dfs(root,0);
        return ansList.get(ansList.size()-1);
    }

    private void dfs(TreeNode root, int depth){
        nowList.add(root);
        if (depth>max){
            max = depth;
            ansList = nowList.stream().collect(Collectors.toList());
        } else if (depth==max){
            for (int i =0;i<ansList.size();i++){
                if (ansList.get(i)!=nowList.get(i)){
                    ansList = ansList.subList(0, i);
                    break;
                }
            }
        }
        if (root.left!=null){
            dfs(root.left, depth+1);
        }
        if (root.right!=null){
            dfs(root.right, depth+1);
        }
        nowList.remove(root);
    }

}
