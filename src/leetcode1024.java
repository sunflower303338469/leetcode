import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by xuanmao on 2020/1/22.
 */
public class leetcode1024 {

    class Clip{
        Integer start;
        Integer end;
        public Clip(Integer start, Integer end){
            this.start = start;
            this.end = end;
        }
    }

    public int videoStitching(int[][] clips, int T) {
        if (clips.length==0){
            return -1;
        }
        List<Clip> clipList = new ArrayList<>();
        for (int i=0;i<clips.length;i++){
            Clip newClip = new Clip(clips[i][0],clips[i][1]);
            clipList.add(newClip);
        }
        clipList.sort(Comparator.comparing(a -> a.start));
        if (clipList.get(0).start!=0){
            return -1;
        }
        int nowStart =0;
        int nowEnd = 0;
        int ans = 0;
        for (Clip clip:clipList){
            if (nowEnd>=T){
                if (nowStart == nowEnd){
                    return ans;
                } else {
                    return ans+1;
                }
            }
            if (clip.start<=nowStart){
                nowEnd = Math.max(nowEnd, clip.end);
            } else if (clip.start<=nowEnd){
                ans++;
                nowStart = nowEnd;
                nowEnd= Math.max(nowEnd, clip.end);
            } else {
                return -1;
            }
            System.out.println(String.format("nowStart:%d nowEnd:%d",nowStart, nowEnd));
        }
        if (nowEnd>=T){
            if (nowStart == nowEnd){
                return ans;
            } else {
                return ans+1;
            }
        }
        return -1;
    }
}
