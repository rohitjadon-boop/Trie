import java.util.*;

public class SuffixString {
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

    SuffixString() {
        root = new TrieNode(' ');
    }

    public void suffixString(String words[], String suffix) {
        for (int i = 0; i < words.length; i++) {
            String reverseString = reverse(words[i]);
            addWord(reverseString, root);
        }
        suffix = reverse(suffix);
        searchWord(suffix, root, suffix);
    }

    private void searchWord(String str, TrieNode root, String ans) {
        if(str.length() == 0) {
            autoComplete(ans.substring(0, ans.length() - 1), root);
            return;
        }
        int childIndex = str.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if(child == null) {
            return;
        }
        searchWord(str.substring(1), child, ans);
    }

    private void autoComplete(String str, TrieNode root) {
//        System.out.println(str);
        if (root == null) {
            return;
        }

        if (root.isTerminating == true) {
            String ans = reverse(str + root.data);
            System.out.println(ans);
        }

        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                autoComplete(str + root.data, root.children[i]);
            }
        }
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

    private String reverse(String str) {
        String ans = "";
        for (int i = 0; i < str.length(); i++) {
            ans = str.charAt(i) + ans;
        }
        return ans;
    }

}
