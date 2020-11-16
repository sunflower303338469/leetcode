import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2020/9/14.
 */
public class leetcode841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visit = new boolean[n];
        visit[0] = true;
        List<Integer> roomList = new ArrayList<>();
        roomList.add(0);
        int l = 0;
        while (l<roomList.size()){
            int nowRoom = roomList.get(l);
            for (Integer nextRoom:rooms.get(nowRoom)){
                if (!visit[nextRoom]){
                    visit[nextRoom] = true;
                    roomList.add(nextRoom);
                }
            }
            l++;
        }
        for (int i =0;i<n;i++){
            if (!visit[i]){
                return false;
            }
        }
        return true;
    }
}
