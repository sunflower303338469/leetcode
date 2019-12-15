import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanmao on 2019/10/27.
 */
public class leetcode5241 {

    boolean[][] vis = new boolean[14][14];
    int nn;
    int mm;
    int ans=99999;
    public int tilingRectangle(int n, int m) {
        if (n>m){
            nn = n;
            mm = m;
        } else {
            mm = n;
            nn = m;
        }
        find(n*m,0);
        return ans;
    }

    public void find(int count, int now){
        if (count ==0){
            if (now<ans){
                ans = now;
            }
            return;
        }
        if (now>=ans){
            return;
        }
        int x = 0;
        int y = 0;
        boolean flag = false;
        for (int i=0;i<nn;i++){
            for (int j =0;j<mm;j++){
                if ((!vis[i][j]) && (!flag)){
                  x = i;
                  y = j;
                  flag = true;
                }
            }
        }
        for (int i =13;i>=1;i--){
            if (count<i*i){
                continue;
            }
            if ((x+i>nn) || (y+i>mm)){
                continue;
            }
            boolean check = true;
            for (int l =0;l<i;l++){
                for (int r=0;r<i;r++){
                    if (vis[x+l][y+r]){
                        check = false;
                    }
                }
            }
            if (check){
                for (int l =0;l<i;l++){
                    for (int r=0;r<i;r++){
                        vis[x+l][y+r]= true;
                    }
                }
            find(count- i*i, now+1);
            for (int l =0;l<i;l++){
                for (int r=0;r<i;r++){
                    vis[x+l][y+r]= false;
                }
            }
            }

        }
    }
}
