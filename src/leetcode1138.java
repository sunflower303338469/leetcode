/**
 * Created by xuanmao on 2019/7/28.
 */
public class leetcode1138 {
    public String alphabetBoardPath(String target) {
        int x =0;
        int y =0;
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<target.length();i++){
            char t = target.charAt(i);
            int tx = (t - 'a')/5;
            int ty = (t-'a') % 5;
            if (tx==5){
                if (y>ty){
                    for (int j = ty;j<y;j++){
                        sb.append('L');
                    }
                } else if (y<ty){
                    for (int j = y;j<ty;j++){
                        sb.append('R');
                    }
                }
                if (x>tx){
                    for (int j = tx;j<x;j++){
                        sb.append('U');
                    }
                } else if (x<tx){
                    for (int j = x;j<tx;j++){
                        sb.append('D');
                    }
                }

            } else {
                if (x>tx){
                    for (int j = tx;j<x;j++){
                        sb.append('U');
                    }
                } else if (x<tx){
                    for (int j = x;j<tx;j++){
                        sb.append('D');
                    }
                }
                if (y>ty){
                    for (int j = ty;j<y;j++){
                        sb.append('L');
                    }
                } else if (y<ty){
                    for (int j = y;j<ty;j++){
                        sb.append('R');
                    }
                }
            }

            x=tx;
            y=ty;
            sb.append('!');
        }
        return sb.toString();
    }
}
