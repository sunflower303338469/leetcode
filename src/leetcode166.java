import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xuanmao on 2019/5/13.
 */
public class leetcode166 {
    public String fractionToDecimal(int numerator, int denominator) {
        Long numer = (long) numerator;
        Long deno = (long) denominator;
        List<Long> xiaoshu = new ArrayList<>();
        Map<Long, Integer> hash = new HashMap<>();
        long zhengshu = (long) numer / deno;
        long yushu = (long) numer % deno;
        if (yushu == 0) {
            return String.valueOf(zhengshu);
        }
        String ans = "";
        if (numer * deno < 0) {
            ans = "-";
        }
        numer = Math.abs(numer);
        deno = Math.abs(deno);
        yushu = Math.abs(yushu);
        zhengshu = Math.abs(zhengshu);
        int xunhuan = -1;
        while (yushu != 0) {
            yushu = yushu * 10;
            long temp = yushu / deno;
            System.out.println(yushu + " " + deno);
            if ((yushu % deno != 0) && (hash.containsKey(yushu))) {
                xunhuan = hash.get(yushu);
                break;
            }
            hash.put(yushu, xiaoshu.size());
            xiaoshu.add(temp);
            yushu = yushu % deno;
        }
        ans = ans + zhengshu + ".";
        for (int i = 0; i < xiaoshu.size(); i++) {
            if (i == xunhuan) {
                ans += "(";
            }

            ans += xiaoshu.get(i);
        }
        if (xunhuan != -1) {
            ans += ")";
        }
        return ans;
    }
}
