import java.util.ArrayList;
import java.util.List;

public class leetcode5070 {

    class Color{
        int x;
        int y;
        int z;
    }

    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        int MAX=  100000;
        Color[] c = new Color[colors.length];

        Color nowColor =new Color();
        nowColor.x = MAX;
        nowColor.y = MAX;
        nowColor.z = MAX;
        for (int i =0;i<colors.length;i++){
            if (nowColor.x!=MAX){
                nowColor.x++;
            }
            if (nowColor.y!=MAX){
                nowColor.y++;
            }
            if (nowColor.z!=MAX){
                nowColor.z++;
            }
            if (colors[i]==1){
                nowColor.x = 0;
            }
            if (colors[i]==2){
                nowColor.y = 0;
            }
            if (colors[i] ==3){
                nowColor.z=0;
            }
            c[i] = new Color();
            c[i].x=nowColor.x;
            c[i].y=nowColor.y;
            c[i].z= nowColor.z;

        }
        nowColor.x = MAX;
        nowColor.y = MAX;
        nowColor.z = MAX;
        for (int i =colors.length-1;i>=0;i--){
            if (nowColor.x!=MAX){
                nowColor.x++;
            }
            if (nowColor.y!=MAX){
                nowColor.y++;
            }
            if (nowColor.z!=MAX){
                nowColor.z++;
            }
            if (colors[i]==1){
                nowColor.x = 0;
            }
            if (colors[i]==2){
                nowColor.y = 0;
            }
            if (colors[i] ==3){
                nowColor.z=0;
            }

            c[i].x=Math.min(c[i].x,nowColor.x);
            c[i].y=Math.min(c[i].y,nowColor.y);
            c[i].z= Math.min(c[i].z,nowColor.z);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i=0;i<queries.length;i++){
            int index = queries[i][0];
            int color = queries[i][1];
            int value = 0;
            if (color == 1){
                value = c[index].x;
            }
            if (color == 2){
                value = c[index].y;
            }
            if (color == 3){
                value = c[index].z;
            }
            if (value == MAX){
                value = -1;
            }
            ans.add(value);
        }
        return ans;
    }
}
