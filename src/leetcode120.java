import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2020/1/22.
 */
public class leetcode120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.isEmpty()){
            return 0;
        }
        List<Integer> sumList= triangle.get(0);
        for (int i =1;i<triangle.size();i++){
            List<Integer> nextLevel = new ArrayList<>();
            for (int j=0;j<triangle.get(i).size();j++){
                if (j==0){
                    nextLevel.add(sumList.get(j)+triangle.get(i).get(j));
                } else if (j==triangle.get(i).size()-1){
                    nextLevel.add(sumList.get(j-1)+triangle.get(i).get(j));
                } else {
                    nextLevel.add(Math.min(sumList.get(j), sumList.get(j-1))+triangle.get(i).get(j));
                }
            }
            sumList = nextLevel;
        }
        int ans = sumList.get(0);
        for (int i=0;i<sumList.size();i++){
            ans = Math.min(ans, sumList.get(i));
        }
        return ans;
    }
}
