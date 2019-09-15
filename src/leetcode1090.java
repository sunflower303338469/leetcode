import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by xuanmao on 2019/6/16.
 */
public class leetcode1090 {
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        int[] vis = new int[20001];
        int ans= 0;
        int p = 0;
        List<Tag> tagList = new ArrayList<>();
        for (int i=0;i<labels.length;i++){
            Tag tag = new Tag();
            tag.label = labels[i];
            tag.value = values[i];
            tagList.add(tag);
        }
        tagList.sort(new Comparator<Tag>() {
            @Override
            public int compare(Tag o1, Tag o2) {
                return -o1.value.compareTo(o2.value);
            }
        });

        for (int i=0;i<tagList.size();i++){
            if (p==num_wanted){
                return ans;
            }
            if (vis[tagList.get(i).label]<use_limit){
                System.out.println(tagList.get(i).label + " " +  tagList.get(i).value);
                vis[tagList.get(i).label] ++;
                ans = ans + tagList.get(i).value;
                p++;
            }
        }
        return ans;
    }
    class Tag{
        public Integer label;
        public Integer value;
    }
}
