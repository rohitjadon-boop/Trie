import java.util.List;

public class ReplaceWords {
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

            ReplaceWords() {
                root = new TrieNode(' ');
            }

            public String replaceWords(List<String> dictionary, String sentence) {
                for(int i=0;i<dictionary.size();i++) {
                    String str = dictionary.get(i);
                    addWord(str, root);
                }
                String words[] = sentence.split(" ");
                String ans = "";
                for(int i=0;i<words.length;i++) {
                    String str = words[i];
                    String temp = searchWord(str, root, "");
                    if(temp.equals("")) {
                        ans = ans + " " + str;
                    }
                    else {
                        ans = ans +" " + temp;
                    }
                }
                return ans.trim();
            }

            private String searchWord(String str, TrieNode root, String ans) {
                if(str.length() == 0) {
                    if(root.isTerminating == true) {
                        return ans;
                    }
                    return "";
                }
                int childIndex = str.charAt(0) - 'a';
                TrieNode child = root.children[childIndex];
                if(child == null) {
                    return "";
                }
                if(child.isTerminating == true) {
                    return ans + child.data;
                }
                String result = searchWord(str.substring(1), child, ans + child.data);
                return result;
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
