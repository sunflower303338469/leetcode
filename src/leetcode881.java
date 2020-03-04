import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by xuanmao on 2019/12/29.
 */
public class leetcode881 {
    public int numRescueBoats(int[] people, int limit) {
        List<Integer> peopleList = new ArrayList<>();
        int ans = 0;
        for (int i =0;i<people.length;i++){
            peopleList.add(people[i]);
        }
        peopleList.sort(Comparator.naturalOrder());
        int l=0;
        int r=peopleList.size()-1;
        while(l<=r){
            if (l==r){
                l++;
            } else {
                int a = peopleList.get(l);
                int b = peopleList.get(r);
                if (a+b<=limit){
                    l++;
                    r--;
                } else {
                    r--;
                }
            }
            ans++;
        }
        return ans;
    }
}
