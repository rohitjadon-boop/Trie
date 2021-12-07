import java.util.*;

public class PrintUniqueString {
    public static class TrieNode {
        char data;
        boolean isTerminating;
        TrieNode children[] = new TrieNode[26];
        int count;
    }

    TrieNode root;

    PrintUniqueString() {
        root = new TrieNode();
        root.data = ' ';
    }

    public void printUniqueString(String words[]) {
        for (int i = 0; i < words.length; i++) {
            String str = words[i];
            addWord(str, root);
        }
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                printWords(root.children[i], "");
            }
        }
    }

    private void printWords(TrieNode root, String ans) {
        if (root == null) {
            return;
        }

        if (root.isTerminating == true && root.count == 1) {
            System.out.println(ans + root.data);
        }

        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                printWords(root.children[i], ans + root.data);
            }
        }

    }

    private void addWord(String str, TrieNode root) {
        if (str.length() == 0) {
            root.isTerminating = true;
            root.count++;
            return;
        }
        int childIndex = str.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if (child == null) {
            child = new TrieNode();
            child.data = str.charAt(0);
            root.children[childIndex] = child;
        }
        addWord(str.substring(1), child);
    }

}
