public class UniqueShortestPrefix {

    TrieNode root;

    UniqueShortestPrefix() {
        root = new TrieNode(' ');
    }

    public void addWord(String[] words) {
        for (int i = 0; i < words.length; i++) {
            String str = words[i];
            addWord(root, str);
        }
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                printUniquePrefixes(root.children[i], "");
            }
        }
    }

    private void printUniquePrefixes(TrieNode root, String ans) {
        if (root == null) {
            return;
        }

        if (root.traverseCount == 1) {
            System.out.println(ans + root.data);
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                printUniquePrefixes(root.children[i], ans + root.data);
            }
        }
    }

    private void addWord(TrieNode root, String str) {
        if (str.length() == 0) {
            return;
        }

        int childIndex = str.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if (child == null) {
            child = new TrieNode(str.charAt(0));
            root.children[childIndex] = child;
        }

        child.traverseCount++;
        addWord(child, str.substring(1));
    }
}
