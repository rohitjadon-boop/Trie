import java.util.*;
public class PreixSuffix {
    public static class TrieNode {
        char data;
        boolean isTerminating;
        TrieNode children[];
        TrieNode(char data) {
            this.data = data;
            children = new TrieNode[27];
        }
    }
    TrieNode root;
    PreixSuffix() {
        root = new TrieNode(' ');
    }

    public void prefixSuffix(String words[], String prefix, String suffix) {
        for(int i=0;i<words.length;i++) {
            String str = "{" + words[i];
            for(int j=str.length()-1;j>=0;j--) {
                str = str.charAt(j) + str;
                addWord(str, root);
            }
        }
        System.out.println(searchWord(suffix+"{"+prefix, root));
    }

    private boolean searchWord(String str, TrieNode root) {
        if(str.length() == 0) {
            return true;
        }
        int childIndex = str.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if (child == null) {
            return false;
        }
        boolean ans = searchWord(str.substring(1), child);
        if(ans == false) {
            return false;
        }
        return true;
    }

    private void addWord(String str ,TrieNode root) {
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
