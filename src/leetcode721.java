import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by xuanmao on 2020/1/21.
 */
public class leetcode721 {

    int[] f;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        f=  new int[accounts.size()];
        for  (int i=0;i<accounts.size();i++){
            f[i] = i;
        }
        Map<String, Integer> map = new HashMap<>();
        for (int j =0;j<accounts.size();j++){
            List<String> account = accounts.get(j);
            for (int  i=1;i<account.size();i++){
                if (map.containsKey(account.get(i))){
                    int f1 = getFather(map.get(account.get(i)));
                    int f2 = getFather(i);
                    System.out.println("merge "+ f1 + " " + f2);
                    f[f1] = f2;
                } else {
                    map.put(account.get(i), j);
                }
            }
        }
        for  (int i=0;i<accounts.size();i++){
            System.out.println("i, f[i] "+ getFather(i));
        }
        Map<Integer, List<String>> emailMap = new HashMap<>();
        for (int i=0;i<accounts.size();i++){
            List<String> emailList = emailMap.getOrDefault(getFather(i),new ArrayList<>());
            for (int  j=1;j<accounts.get(i).size();j++){
                emailList.add(accounts.get(i).get(j));
            }
            emailMap.put(getFather(i),emailList);
        }
        List<List<String>> ans = new ArrayList<>();
        for (Integer index:emailMap.keySet()){
            List<String> ansList = new ArrayList<>();
            ansList.add(accounts.get(index).get(0));
            List<String> e = emailMap.get(index).stream().distinct().sorted().collect(Collectors.toList());
            ansList.addAll(e);
            ans.add(ansList);
        }
        return ans;
    }

    private int getFather(Integer index){
        while (f[index] != index){
            f[index] = f[f[index]];
            index = f[index];
        }
        return index;
    }

}
