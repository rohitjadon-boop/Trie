import java.util.*;

public class LongestPrefix {
    public static class TrieNode {
        char data;
        boolean isTerminating;
        TrieNode children[];
        int count;

        TrieNode(char data) {
            this.data = data;
            children = new TrieNode[26];
        }
    }

    TrieNode root;

    String first = "";
    String second = "";
    int length = 0;

    LongestPrefix() {
        root = new TrieNode(' ');
    }

    public void longestPrefix(String words[]) {
        for (int i = 0; i < words.length; i++) {
            String str = words[i];
            addWord(str, root);
        }
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null && root.children[i].count > 1) {
                searchWord(root.children[i], root.children[i].data + "");
            }
        }
        System.out.println(first + " " + second);
    }

    private void searchWord(TrieNode root, String prefix) {
        if (root == null) {
            return;
        }
        boolean flag = true;
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null && root.children[i].count > 1) {
                searchWord(root.children[i], prefix + root.children[i].data);
                flag = false;
            }
        }

        if (flag == true && (prefix + root.data).length() > length) {
            length = (prefix + root.data).length();
            int count = 0;
            for (int i = 0; i < 26 && count < 2; i++) {
                if (root.children[i] != null) {
                    count++;
                    potentialPrefix(root.children[i], prefix);
                }
            }
        }
    }

    private void potentialPrefix(TrieNode root, String str) {
        if (root == null) {
            return;
        }

        if (root.isTerminating) {
            first = second;
            second = str + root.data;
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                potentialPrefix(root.children[i], str + root.data);
            }
        }
    }

    private void addWord(String str, TrieNode root) {
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
        child.count++;
        addWord(str.substring(1), child);
    }

}
