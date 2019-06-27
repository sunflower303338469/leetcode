import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xuanmao on 2019/6/23.
 */
public class leetcode1096 {
    String e;
    public List<String> braceExpansionII(String expression) {
        e = expression;
        Set<String> ans = getkuohao(0);
        List<String> a = new ArrayList<>(ans);
        a.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        return a;
    }

    private Set<String> getkuohao(int index){
        Set<String> ans = new LinkedHashSet<>();
        Set<String> now = new LinkedHashSet<>();
        now.add("");
        int kuohaocount = 0;
        for (int i =index;i<e.length();i++){
            if (e.charAt(i)=='{'){
                if (kuohaocount == 0){
                    Set<String> st = getkuohao(i+1);
                    System.out.println(st.toString());
                    Set<String> newNow = new LinkedHashSet<>();
                    for (String s:now){
                        for (String ss:st){
                            newNow.add(s+ss);
                        }
                    }
                    now = newNow;
                }
                kuohaocount +=1;
            } else if (e.charAt(i) == '}'){
                kuohaocount -=1;
                if (kuohaocount<0){
                    for (String s:now){
                        if (!"".equals(s)){
                            ans.add(s);
                        }
                    }
                    return ans;
                }
            } else if (e.charAt(i) == ',') {
                if (kuohaocount == 0){
                    ans.addAll(now);
                    now = new LinkedHashSet<>();
                    now.add("");
                }
            } else if (kuohaocount ==0){
                Set<String> newNow = new LinkedHashSet<>();
                for (String s:now){
                    newNow.add(s+e.charAt(i));
                }
                now = newNow;
            }

        }
        for (String s:now){
            if (!"".equals(s)){
                ans.add(s);
            }
        }
        return ans;
    }
}
