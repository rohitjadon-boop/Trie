public class LongestWord {
    class TrieNode {
        char data;
        boolean isTerminating;
        TrieNode children[];
        TrieNode(char data) {
            this.data = data;
            children = new TrieNode[26];
        }
    }

        String ans = "";

        TrieNode root;

    LongestWord() {
            root = new TrieNode(' ');
        }

        public String longestWord(String[] words) {
            for(int i=0;i<words.length;i++) {
                String str = words[i];
                addWord(root, str);
            }

            for(int i=0;i<26;i++) {
                if(root.children[i] != null) {
                    searchWord(root.children[i], root.children[i].data+"");
                }
            }
            return ans;
        }

        private void searchWord(TrieNode root, String str) {

            if(root == null || root.isTerminating == false) {
                return ;
            }

            if(str.length() > ans.length()) {
                ans = str;
            }

            for(int i=0;i<26;i++) {
                if(root.children[i] != null) {
                    searchWord(root.children[i], str + root.children[i].data);
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
