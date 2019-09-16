import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by xuanmao on 2019/8/8.
 */
public class leetcode833 {

    class Replace{
        Integer indexes;
        String sources;
        String targets;
    }

    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        StringBuilder sb = new StringBuilder();
        List<Replace> replaceList = new ArrayList<>();

        for (int i =0;i<indexes.length;i++){
            Replace re = new Replace();
            re.indexes = indexes[i];
            re.sources = sources[i];
            re.targets = targets[i];
            replaceList.add(re);
        }

        replaceList.sort(new Comparator<Replace>() {
            @Override
            public int compare(Replace o1, Replace o2) {
                return o1.indexes.compareTo(o2.indexes);
            }
        });
        int p =0;
        int head = 0;
        while (head<S.length()){
            if (p<replaceList.size()){
                Replace r = replaceList.get(p);
                if (head == r.indexes){
                    if (S.length()>=head+r.sources.length()){
                        if (S.substring(head, head+r.sources.length()).equals(r.sources)){
                            sb.append(r.targets);
                            p=p+1;
                            head = head + r.sources.length();
                            continue;
                        }
                    }
                    p = p+1;
                }
            }
            sb.append(S.charAt(head));
            head = head+1;
        }
        return sb.toString();
    }
}
