import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by xuanmao on 2019/6/16.
 */
public class leetcode815 {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (S==T){
            return 0;
        }
        boolean[] busVisit = new boolean[routes.length];
        Map<Integer, PointBus> pointBusMap = new HashMap<>();
        Set<Integer> pointVisit = new HashSet<>();
        for (int i=0;i<routes.length;i++){
            for (int j=0;j<routes[i].length;j++){
                PointBus pb = new PointBus();
                pb.bus = i;
                if (pointBusMap.get(routes[i][j]) == null){
                    pointBusMap.put(routes[i][j], pb);
                } else {
                    pb.next = pointBusMap.get(routes[i][j]);
                    pointBusMap.put(routes[i][j], pb);
                }
            }
        }
        List<Integer> queue = new ArrayList<>();
        List<Integer> value = new ArrayList<>();
        PointBus p = pointBusMap.get(S);
        pointVisit.add(S);
        if (p==null){
            return -1;
        }
        while (p!=null){
            busVisit[p.bus] = true;
            for (int i=0;i<routes[p.bus].length;i++){
                if (!pointVisit.contains(routes[p.bus][i])){
                    pointVisit.add(routes[p.bus][i]);
                    queue.add(routes[p.bus][i]);
                    value.add(1);
                }
            }
            p=p.next;
        }
        int top = 0;
        while (top<queue.size()){
            if (queue.get(top) == T){
                return value.get(top);
            }
            PointBus temp = pointBusMap.get(queue.get(top));
            while (temp!=null){
                if (!busVisit[temp.bus]){
                    busVisit[temp.bus] = true;
                    for (int i=0;i<routes[temp.bus].length;i++){
                        if (!pointVisit.contains(routes[temp.bus][i])){
                            if (routes[temp.bus][i] == T){
                                return value.get(top) + 1;
                            }
                            pointVisit.add(routes[temp.bus][i]);
                            queue.add(routes[temp.bus][i]);
                            value.add(value.get(top) + 1);
                        }
                    }
                }
                temp=temp.next;
            }
            top = top+1;
        }

        return -1;
    }

    class PointBus{
        int bus;
        PointBus next;
    }
}
