/**
 * Created by xuanmao on 2020/4/12.
 */
public class leetcode5382 {
    public String entityParser(String text) {
        StringBuilder sb = new StringBuilder();
        for (int i =0;i<text.length();i++){
            if (text.charAt(i)=='&'){
                int j = i+4;
                if (j<=text.length()){
                    if (text.substring(i,j).equals("&gt;")){
                        sb.append(">");
                        i=j-1;
                        continue;
                    }
                    if (text.substring(i,j).equals("&lt;")){
                        sb.append("<");
                        i=j-1;
                        continue;
                    }
                }
                j = i+5;
                if (j<=text.length()){
                    if (text.substring(i,j).equals("&amp;")){
                        sb.append("&");
                        i=j-1;
                        continue;
                    }
                }
                j=i+6;
                if (j<=text.length()){
                    if (text.substring(i,j).equals("&quot;")){
                        sb.append("\"");
                        i=j-1;
                        continue;
                    }
                }
                if (j<=text.length()){
                    if (text.substring(i,j).equals("&apos;")){
                        sb.append("'");
                        i=j-1;
                        continue;
                    }
                }
                j=i+7;
                if (j<=text.length()){
                    if (text.substring(i,j).equals("&frasl;")){
                        sb.append("/");
                        i=j-1;
                        continue;
                    }
                }
            }
                sb.append(text.charAt(i));
        }
        return sb.toString();
    }
}
