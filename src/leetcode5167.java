import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2019/8/25.
 */
public class leetcode5167 {


    public List<String> invalidTransactions(String[] transactions) {
        List<String> ans = new ArrayList<>();
        for (int i =0;i<transactions.length;i++){
            String[] sp = transactions[i].split(",");
            if (Integer.valueOf(sp[2])>1000){
                ans.add(transactions[i]);
                continue;
            }
            for (int j=0;j<transactions.length;j++){
                String[] sp2 = transactions[j].split(",");
                if ((sp[0].equals(sp2[0])) && (!sp[3].equals(sp2[3])) && (Math.abs(Integer.valueOf(sp[1]) - Integer.valueOf(sp2[1]))<=60)){
                    ans.add(transactions[i]);
                    break;
                }
            }
        }
        return ans;
    }
}
