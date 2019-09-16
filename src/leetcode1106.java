import java.util.Stack;

/**
 * Created by xuanmao on 2019/6/30.
 */
public class leetcode1106 {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> v = new Stack<>();
        Stack<Boolean> f = new Stack<>();
        Stack<Integer> num = new Stack<>();
        int i=0;
        int n = 0;
        while (i<expression.length()){
            Character c = expression.charAt(i);
            if ((c=='!') || (c=='&') || (c=='|')){
                v.push(c);
            } else if (c=='('){
                num.push(n);
                n=0;
            } else if (c==')'){
                Character p = v.pop();
                System.out.println(n);

                if (p == '!'){
                    Boolean s = f.pop();
                    System.out.println("! " + !s);
                    f.push(!s);
                } else if (p == '&'){
                    Boolean s = true;

                    while (n>0){
                        n--;
                        s = s && f.pop();
                        System.out.println(f.toString());
                    }
                    System.out.println("& " + s);
                    f.push(s);
                } else if (p == '|'){
                    Boolean s = false;
                    while (n>0){
                        n--;
                        s = f.pop() || s;
                    }
                    System.out.println("| " + s);
                    f.push(s);
                }
                if (!num.empty()){
                    n = num.pop();
                }
                n= n+1;
            } else if (c!=','){
                n = n+1;
                if (c=='t'){
                    f.push(true);
                } else{
                    f.push(false);
                }
            }
            i=i+1;
        }
        return f.pop();
    }
}
