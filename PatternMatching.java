public class PatternMatching {
    private final TrieNode root;

    PatternMatching() {
        root = new TrieNode(' ');
    }

    public void patternMatching(String[] words) {
        for (int i = 0; i < words.length; i++) {
            String str = words[i];
            for (int j = 0; j < str.length(); j++) {
                addWord(str.substring(j), root);
            }
        }
    }

    public boolean searchWord(String str) {
        return searchWord(str, root);
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
        addWord(str.substring(1), child);
    }

    private boolean searchWord(String str, TrieNode root) {
        if (str.length() == 0) {
            return true;
        }
        int childIndex = str.charAt(0) - 'a';
        TrieNode child = root
                .children[childIndex];
        if (child == null) {
            return false;
        }
        boolean ans = searchWord(str.substring(1), child);
        return ans != false;
    }

}
