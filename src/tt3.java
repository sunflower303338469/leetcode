import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class tt3 {
    public String[] permute(String S) {
        List<String> now = new ArrayList<>();
        List<String> before = new ArrayList<>();
        before.add("");
        for (int i=0;i<S.length();i++){
            if (S.charAt(i) == '{'){
                String t = "";
                i++;
                while (S.charAt(i)!='}'){
                    t = t+S.charAt(i);
                    i++;
                }
                String[] cha = t.split(",");
                now = new ArrayList<>();
                for (int j = 0;j<cha.length;j++){
                    System.out.println(cha[j]);
                    for (int k=0;k<before.size();k++){
                        now.add(before.get(k)+cha[j]);
                    }
                }
                before = now;
            } else {
                for (int j =0;j<before.size();j++){
                    before.set(j, before.get(j)+S.charAt(i));
                }
            }
        }
        before.sort(new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return s.compareTo(t1);
            }
        });
        String [] ans= new String[before.size()];
        for (int i=0;i<ans.length;i++){
            ans[i] = before.get(i);
        }
        return ans;
    }
}
