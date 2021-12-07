public class TriePrefix {
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
        public TriePrefix() {
            root = new TrieNode(' ');
        }

        public void insert(String word) {
            insertWord(word, root);
        }

        private void insertWord(String str, TrieNode root) {
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
            insertWord(str.substring(1), child);
        }

        public boolean search(String word) {
            return searchWord(word, root);
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

        public boolean startsWith(String prefix) {
            return isPrefix(prefix, root);
        }

        private boolean isPrefix(String str, TrieNode root) {
            if(str.length() == 0) {
                return true;
            }
            int childIndex = str.charAt(0) - 'a';
            TrieNode child = root.children[childIndex];
            if(child == null) {
                return false;
            }
            boolean isPrefixPresent = isPrefix(str.substring(1), child);
            if(isPrefixPresent == false) {
                return false;
            }
            return true;
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
