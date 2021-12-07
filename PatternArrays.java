import java.util.*;

public class PatternArrays {
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

    PatternArrays() {
        root = new TrieNode(' ');
    }

    public void patternArrays(String words[], String pattern) {
        for (int i = 0; i < words.length; i++) {
            String str = words[i];
            addWord(root, str);
        }
        searchWord(root, pattern, "");
    }

    private void searchWord(TrieNode root, String str, String ans) {
        if (root == null) {
            return;
        }

        if(str.length() == 0) {
            if(root.isTerminating) {
                System.out.println(ans);
            }
            return;
        }

        if (str.charAt(0) != '.') {
            int childIndex = str.charAt(0) - 'a';
            TrieNode child = root.children[childIndex];
            if (child == null) {
                return;
            }
            searchWord(child, str.substring(1), ans + child.data);
        } else {
            for (int i = 0; i < 26; i++) {
                if (root.children[i] != null) {
                    searchWord(root.children[i], str.substring(1), ans + root.children[i].data);
                }
            }
        }
    }

    private void addWord(TrieNode root, String str) {
        if (str.length() == 0) {
            root.isTerminating = true;
            return;
        }
        int childIndex = str.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if (child == null) {
            child = new TrieNode(str.charAt(0));
            root.children[childIndex] = child;
        }
        addWord(child, str.substring(1));
    }
}
