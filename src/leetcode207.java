import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xuanmao on 2020/4/6.
 */
public class leetcode207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] visit = new boolean[numCourses];
        int[] rudu = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i =0;i<prerequisites.length;i++){
            int x = prerequisites[i][0];
            int y = prerequisites[i][1];
            rudu[x]++;
            List<Integer> list = map.getOrDefault(y,new ArrayList<>());
            list.add(x);
            map.put(y,list);
        }
        while (true){
            boolean flag = true;
            for (int i=0;i<numCourses;i++){
                if ((rudu[i]==0) && (!visit[i])){
                    visit[i] = true;
                    flag = false;
                    List<Integer> list = map.getOrDefault(i,new ArrayList<>());
                    for (Integer p:list){
                        rudu[p]--;
                    }
                }
            }

            if (flag){
                break;
            }
        }
        for (int i =0;i<numCourses;i++){
            if (!visit[i]){
                return false;
            }
        }
        return true;
    }
}
