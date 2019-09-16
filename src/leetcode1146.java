import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xuanmao on 2019/8/4.
 */
public class leetcode1146 {
    class SnapshotArray {

        class Snap{
            int index;
            int val;
            int snapNum;
        }

        int nowSnap = -1;
        Map<Integer, List<Snap>> snapK = new HashMap<>();

        public SnapshotArray(int length) {
        }

        public void set(int index, int val) {
            Snap s = new Snap();
            s.index = index;
            s.val = val;
            s.snapNum = nowSnap;

            List<Snap> snaps = snapK.get(index);
            if (snaps==null){
                snaps = new ArrayList<>();

            }
            snaps.add(s);
            snapK.put(index, snaps);
        }

        public int snap() {
            nowSnap++;
            return nowSnap;
        }

        public int get(int index, int snap_id) {
            List<Snap> snaps = snapK.get(index);
            if (snaps == null){
                return 0;
            }
            int l =0;
            int r =snaps.size();
            while (l<r){
                int mid = (l+r)/2;
                Snap snap = snaps.get(mid);
                if (snap.snapNum>=snap_id){
                    r = mid;
                } else {
                    l= mid+1;
                }
            }
            while ((l<snaps.size()-1) && (snaps.get(l).snapNum<snap_id)){
                l++;
            }
            while ((l>snaps.size()-1) || ((l>=0) && (snaps.get(l).snapNum>=snap_id))){
                l--;
            }
            if (l<0){
                return 0;
            }
            return snaps.get(l).val;

        }
    }


    @Test
    public void s(){
        SnapshotArray snapshotArray = new SnapshotArray(3);
        snapshotArray.set(0,5);
        snapshotArray.snap();
        snapshotArray.set(0,6);
        snapshotArray.get(0,0);
    }
}
