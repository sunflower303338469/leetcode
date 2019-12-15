/**
 * Created by xuanmao on 2019/12/9.
 */
public class leetcode208 {
    class Trie {

        class Node {
            public Node[] children = new Node[26];
            boolean wordTag = false;
        }

        private Node root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new Node();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            Node now = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (now.children[index] == null) {
                    now.children[index] = new Node();
                }
                now = now.children[index];
                if (i == word.length() - 1) {
                    now.wordTag = true;
                }
            }
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            Node now = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (now.children[index] == null) {
                    return false;
                }
                now = now.children[index];
            }
            return now.wordTag;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            Node now = root;
            for (int i = 0; i < prefix.length(); i++) {
                int index = prefix.charAt(i) - 'a';
                if (now.children[index] == null) {
                    return false;
                }
                now = now.children[index];
            }
            return true;
        }
    }
}
