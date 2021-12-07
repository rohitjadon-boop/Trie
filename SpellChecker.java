import java.util.*;
public class SpellChecker {
    public static class TrieNode {
        char data;
        boolean isTerminating;
        TrieNode children[];
        TrieNode(char data) {
            this.data = data;
            children = new TrieNode[26];
        }
    }

    TrieNode root;

    public SpellChecker() {
        root = new TrieNode(' ');
    }

    public void spellChecker(String words[], String word) {
        for(int i=0;i<words.length;i++) {
            String str = words[i];
            addWord(str, root);
        }
        boolean isPresent = searchWord(word, root);
        if(isPresent) {
            System.out.println(word);
            return;
        }
        search(word, root, word);
    }

    private void search(String str, TrieNode root, String originalWord) {
        if (str.length() == 0) {
            autoComplete(originalWord.substring(0, originalWord.length() - 1), root);
            return;
        }
        int childIndex = str.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if (child == null) {
            return;
        }
        search(str.substring(1), child, originalWord);
    }

    private void autoComplete(String str, TrieNode root) {
        if (root == null) {
            return;
        }

        if (root.isTerminating == true) {
            System.out.println(str + root.data);
        }

        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                autoComplete(str + root.data, root.children[i]);
            }
        }
    }

    private boolean searchWord(String str, TrieNode root) {
        if(str.length() == 0) {
            return root.isTerminating ? true : false;
        }
        int childIndex = str.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if(child == null) {
            return false;
        }
        boolean isWordPresent = searchWord(str.substring(1), child);
        if(isWordPresent == false) {
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
