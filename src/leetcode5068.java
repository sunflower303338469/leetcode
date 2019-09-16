import java.util.*;

public class leetcode5068 {
    public static String[] beforeAndAfterPuzzles(String[] phrases) {
        Set<String> newPhrase = new HashSet<>();
        for (int i =0;i<phrases.length;i++){
            for (int j=0;j<i;j++){
                String[] a = phrases[i].split(" ");
                String[] b = phrases[j].split(" ");
                if (a[0].equals(b[b.length-1])){
                    String sb = new String(phrases[j]);
                    for (int k=1;k<a.length;k++){
                        sb= sb+" "+a[k];
                    }
                    newPhrase.add(sb);
                }
                if (b[0].equals(a[a.length-1])){
                    String sb = new String(phrases[i]);
                    for (int k=1;k<b.length;k++){
                        sb= sb+" "+b[k];
                    }
                    newPhrase.add(sb);
                }
            }
        }
        List<String> ansList=  new ArrayList<>();
        ansList.addAll(newPhrase);
        ansList.sort(new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return s.compareTo(t1);
            }
        });
        String[] ans = new String[ansList.size()];
        for (int i =0;i<ansList.size();i++){
            ans[i] = ansList.get(i);
        }
        return ans;
    }


    public static void main(String args[]) {
        String[] v = {"writing code","code rocks"};
        System.out.println(beforeAndAfterPuzzles(v));
    }
}
