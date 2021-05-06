import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by xuanmao on 2021/4/29.
 */
public class leetcode1451 {
    class Word {
        String word;
        Integer index;

        public Word(Integer index, String word) {
            this.index = index;
            this.word = word;
        }
    }

    public String arrangeWords(String text) {
        String[] words=  text.split(" ");
        List<Word> wordList = new ArrayList<>();
        for (int i =0;i<words.length;i++){
            wordList.add(new Word(i,words[i].toLowerCase()));
        }
        wordList.sort(Comparator.comparing((Word p)->p.word.length()).thenComparing((Word q)->q.index));
        StringBuilder ans =  new StringBuilder(String.join(" ",wordList.stream().map(p->p.word).collect(Collectors.toList())));
        if (ans.length()!=0){
            ans.setCharAt(0, (char)(ans.charAt(0)-32));
        }
        return ans.toString();
    }
}
