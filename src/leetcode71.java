import java.util.Stack;

/**
 * Created by xuanmao on 2019/7/8.
 */
public class leetcode71 {
    public String simplifyPath(String path) {
        Stack<String> s = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == '/') {
                if (stringBuilder.length() > 0) {
                    String ss = stringBuilder.toString();
                    if (ss.equals(".")) {
                    } else if (ss.equals("..")) {
                        if (!s.empty()) {
                            s.pop();
                        }
                    } else {
                        s.push(ss);
                    }
                    stringBuilder = new StringBuilder();
                }
            } else {
                stringBuilder.append(path.charAt(i));
            }
        }
        if (stringBuilder.length() > 0) {
            String ss = stringBuilder.toString();
            if (ss.equals(".")) {
            } else if (ss.equals("..")) {
                if (!s.empty()) {
                    s.pop();
                }
            } else {
                s.push(ss);
            }
        }
        if (s.empty()) {
            return "/";
        } else {
            StringBuilder sb = new StringBuilder();
            while (!s.empty()) {
                sb.insert(0, "/" + s.pop());
            }
            return sb.toString();
        }
    }
}
