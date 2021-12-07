import java.util.*;
public class TwoWords {
    TrieNode root;

    TwoWords() {
        root = new TrieNode(' ');
    }

    public void concatenateWords(String words[], String word) {
        for(int i=0;i<words.length;i++) {
            String str = words[i];
            addWord(str, root);
        }

        for(int i=0;i<word.length();i++) {
            if(searchWord(word.substring(0, i+1), root) && searchWord(word.substring(i+1), root)) {
                System.out.println(true);
                return;
            }
        }
        System.out.println(false);
    }

    private boolean searchWord(String str, TrieNode root) {
        if(str.length() == 0) {
            if(root.isTerminating) {
                return true;
            }
            return false;
        }
        int childIndex = str.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if(child == null) {
            return false;
        }
        boolean ans = searchWord(str.substring(1), child);
        if(ans == false) {
            return false;
        }
        return true;

    }

    private void addWord(String str, TrieNode root) {
        if(str.length() == 0) {
            root.isTerminating = true;
            return;
        }
        int childIndex = str.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if(child == null) {
            child = new TrieNode(str.charAt(0));
            root.children[childIndex] = child;
        }
        addWord(str.substring(1), child);
    }
}
