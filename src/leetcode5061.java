import java.util.HashMap;
import java.util.Map;

public class leetcode5061 {


    class FileSystem {

        Map<String, Integer> fs ;
        public FileSystem() {
            fs = new HashMap<>();
        }

        public boolean create(String path, int value) {
            if ((path.length()==0) || (path.equals("/"))){
                return false;
            }
            int pos = -1;
            for (int j=path.length()-1;j>=0;j--){
                if (path.charAt(j)=='/'){
                    pos = j;
                    break;
                }
            }
            if (pos == -1){
                return false;
            }
            String fpath = path.substring(0,pos);
            System.out.println(fpath);
            if ((pos!=0) && (!fs.containsKey(fpath))){
                return false;
            }


            fs.put(path,value);
            return true;
        }

        public int get(String path) {
            Integer value = fs.get(path);
            if (value==null){
                return -1;
            }
            return value;
        }
    }
}
