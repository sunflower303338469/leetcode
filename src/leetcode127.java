import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by xuanmao on 2019/6/14.
 */
public class leetcode127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int ans = 0;
        List<String> queue = new ArrayList<>();
        Map<String, Integer> visit = new HashMap<>();
        queue.add(beginWord);
        visit.put(beginWord, 1);
        int h = 0;
        while (h<queue.size()){
            String head= queue.get(h);
            if (head.equals(endWord)){
                return visit.get(head);
            }
            for (int i=0;i<wordList.size();i++){
                if ((null == visit.get(wordList.get(i))) && (check(head, wordList.get(i)))){
                    queue.add(wordList.get(i));
                    visit.put(wordList.get(i), visit.get(head)+1);
                }
            }
            h++;
        }
        return 0;
    }

    private boolean check(String s1, String s2){
        int diff = 0;
        for (int i=0;i<s1.length();i++){
            if (s1.charAt(i) != s2.charAt(i)){
                diff ++;
            }
        }
        return diff == 1;
    }
}
