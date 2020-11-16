/**
 * Created by xuanmao on 2020/9/24.
 */
public class leetcode640 {
    class Result {
        int xCount;
        int num;
    }

    public String solveEquation(String equation) {
        String[] sList = equation.split("=");
        Result left = getResult(sList[0]);
        Result right = getResult(sList[1]);
        if (left.xCount == right.xCount) {
            if (left.num != right.num) {
                return "No solution";
            } else {
                return "Infinite solutions";
            }
        } else {
            return "x=" + (right.num - left.num) / (left.xCount - right.xCount);
        }
    }

    private Result getResult(String s) {
        Result result = new Result();
        Integer now = null;
        boolean plus = true;
        for (int i =0;i<s.length();i++){
            if ((s.charAt(i)>='0') && (s.charAt(i)<='9')){
                if (now == null){
                    now = 0;
                }
                now = now * 10 + s.charAt(i)-'0';
            } else if (s.charAt(i)=='x'){
                if (now == null){
                    now= 1;
                }
                if (plus){
                    result.xCount += now;
                } else {
                    result.xCount -= now;
                }
                now = 0;
            } else if (s.charAt(i)=='+'){
                if (now == null){
                    now = 0;
                }
                if (plus){
                    result.num += now;
                } else {
                    result.num -=now;
                }
                now = null;
                plus = true;
            } else if (s.charAt(i)=='-'){
                if (now == null){
                    now = 0;
                }
                if (plus){
                    result.num += now;
                } else {
                    result.num -=now;
                }
                now = null;
                plus = false;
            }
        }
        if (now == null){
            now = 0;
        }
        if (plus){
            result.num += now;
        } else {
            result.num -=now;
        }
        return result;
    }
}
