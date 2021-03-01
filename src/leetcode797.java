import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by xuanmao on 2021/2/25.
 */
public class leetcode797 {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        list.add(Collections.singletonList(0));
        int l = 0;
        while (l < list.size()) {
            List<Integer> nowList = list.get(l);
            Integer nowNode = nowList.get(nowList.size()-1);
            for (Integer nextNode:graph[nowNode]){
                List<Integer> newList=  new ArrayList<>();
                newList.addAll(nowList);
                newList.add(nextNode);
                if (nextNode == graph.length-1){
                    ans.add(newList);
                } else {
                    list.add(newList);
                }
            }
            l++;
        }
        return ans;
    }

}
