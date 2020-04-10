import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by xuanmao on 2020/4/6.
 */
public class leetcode1366 {

    class Team{
        private Character c;
        private int[] count;
    }

    public String rankTeams(String[] votes) {
        Map<Character, Team> map = new HashMap<>();
        for (int i =0;i<votes.length;i++){
            for (int j = 0;j<votes[i].length();j++){
                if (map.containsKey(votes[i].charAt(j))){
                    Team t = map.get(votes[i].charAt(j));
                    t.count[j]++;
                    map.put(votes[i].charAt(j), t);
                } else {
                    Team t = new Team();
                    t.c = votes[i].charAt(j);
                    t.count = new int[votes[i].length()];
                    t.count[j]++;
                    map.put(votes[i].charAt(j), t);
                }
            }
        }
        List<Team> teamList = map.values().stream().collect(Collectors.toList());
        teamList.sort(new Comparator<Team>() {
            @Override
            public int compare(Team o1, Team o2) {
                for (int i=0;i<o1.count.length;i++){
                    if (o1.count[i]<o2.count[i]){
                        return 1;
                    }
                    if (o1.count[i]>o2.count[i]){
                        return -1;
                    }
                }
                return o1.c.compareTo(o2.c);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<teamList.size();i++){
            sb.append(teamList.get(i).c);
        }
        return sb.toString();
    }
}
