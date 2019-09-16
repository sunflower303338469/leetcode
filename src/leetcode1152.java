import java.util.*;

public class leetcode1152 {
    class Visit{
        String username;
        Integer timestamp;
        String website;
    }

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        List<String> ans = new ArrayList<>();
        int max = 0;
        List<Visit> visitList = new ArrayList<>();
        for (int i =0;i<username.length;i++){
            Visit visit = new Visit();
            visit.username = username[i];
            visit.timestamp = timestamp[i];
            visit.website = website[i];
            visitList.add(visit);
        }
        visitList.sort(new Comparator<Visit>() {
            @Override
            public int compare(Visit visit, Visit t1) {
                return visit.timestamp.compareTo(t1.timestamp);
            }
        });
        Map<String, List<String>> visitWay = new HashMap<>();
        for (Visit visit:visitList){
            List<String> sList = visitWay.get(visit.username);
            if (sList == null){
                List<String> temp = new ArrayList<>();
                temp.add(visit.website);
                visitWay.put(visit.username, temp);
            } else {
                sList.add(visit.website);
                visitWay.put(visit.username, sList);
            }
        }
        Map<List<String>, Integer> ansCount = new HashMap<>();
        for (String name:visitWay.keySet()){
            List<String> webList = visitWay.get(name);
            if (webList.size()>=3){
                Set<List<String>> matchSet = new HashSet<>();
                for (int i=0;i<webList.size();i++){
                    for (int j =i+1;j<webList.size();j++){
                        for (int k = j+1;k<webList.size();k++){
                            List<String> temp = new ArrayList<>();
                            temp.add(webList.get(i));
                            temp.add(webList.get(j));
                            temp.add(webList.get(k));
                            if (matchSet.contains(temp)){
                                continue;
                            }
                            matchSet.add(temp);
                            Integer count = ansCount.get(temp);
                            if (count == null){
                                count =1;
                            } else {
                                count = count +1;
                            }
                            ansCount.put(temp, count);
                            if (count>=max){
                                if ( (count == max) && ((ans.size()==0) || (isBigger(ans, temp)))){
                                    ans = temp;
                                } else if(count>max){
                                    ans =temp;
                                }
                                max = count;

                            }
                        }
                    }
                }
            }

        }

        return ans;
    }

    private boolean isBigger(List<String> a, List<String> b){
        System.out.println(a.get(0) + " "+ a.get(1)+ " "+ a.get(2));
        System.out.println(b.get(0) + " "+ b.get(1)+ " "+ b.get(2));
        int x0 = a.get(0).compareTo(b.get(0));
        int x1 = a.get(1).compareTo(b.get(1));
        int x2 = a.get(2).compareTo(b.get(2));
        if ((x0>0) || ((x0==0) && (x1>0)) || ((x0==0) && (x1==0) && (x2>0))){
            return true;
        }
        return false;
    }


}
