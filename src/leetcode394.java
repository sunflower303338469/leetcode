import java.util.Stack;

/**
 * Created by xuanmao on 2019/4/10.
 */
public class leetcode394 {
    public String decodeString(String s) {
        String ans = "";
        Stack<Integer> numberStack = new Stack<Integer>();
        Stack<String> stringStack = new Stack<String>();
        numberStack.push(0);
        stringStack.push("");
        int h = 0;
        while (h<s.length()){
            if (s.charAt(h) == '['){
                numberStack.push(0);
                stringStack.push("");
            } else if (s.charAt(h) == ']'){
                numberStack.pop();
                Integer num = numberStack.pop();
                String str = stringStack.pop();
                String calstr = "";
                for (int i =0; i< num; i++){
                    calstr = calstr + str;
                }
                if (stringStack.empty()){
                    ans += calstr;
                    stringStack.push("");
                } else {
                    String preStr = stringStack.pop();
                    preStr += calstr;
                    stringStack.push(preStr);
                }
                numberStack.push(0);
            } else if (s.charAt(h) >='0' && s.charAt(h) <='9'){
                Integer now = numberStack.pop();
                now = now*10 +  Integer.parseInt(String.valueOf(s.charAt(h)));
                numberStack.push(now);
            } else {
                String nowStr = stringStack.pop();
                nowStr = nowStr + s.charAt(h);
                stringStack.push(nowStr);
            }
            h = h+1;
        }
        ans = ans + stringStack.pop();
        return ans;
    }
}
