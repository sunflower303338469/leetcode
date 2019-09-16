import java.util.ArrayList;
import java.util.List;

public class leetcode1136 {


    class Pointer {
        Pointer next;
        Integer v;
    }

    public int minimumSemesters(int N, int[][] relations) {
        int[] du = new int[5001];
        boolean[] learn = new boolean[5001];
        Pointer[] p = new Pointer[5001];
        for (int i = 0; i < relations.length; i++) {
            du[relations[i][1]]++;
            Pointer pointer = new Pointer();
            pointer.v = relations[i][1];
            pointer.next = p[relations[i][0]];
            p[relations[i][0]] = pointer;
        }
        int ans = 0;
        List<Integer> l = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (du[i] == 0) {
                l.add(i);
                learn[i] = true;
            }
        }

        while (l.size() > 0) {
            ans++;
            List<Integer> next = new ArrayList<>();
            for (Integer x : l) {
                Pointer pointer = p[x];
                while ((pointer != null) && (pointer.v != null)) {
                    du[pointer.v]--;
                    if (du[pointer.v] == 0) {
                        next.add(pointer.v);
                        learn[pointer.v] = true;
                    }
                    pointer = pointer.next;
                }
            }
            l = next;
        }

        for (int i = 1; i < N; i++) {
            if (!learn[i]) {
                return -1;
            }
        }
        return ans;
    }

}
