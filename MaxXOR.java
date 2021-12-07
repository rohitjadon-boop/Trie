import java.util.*;

public class MaxXOR {
    public static class TrieNode {
        int data;
        TrieNode left;
        TrieNode right;

        TrieNode(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    TrieNode root;

    MaxXOR() {
        root = new TrieNode(' ');
    }

    public void maxXor(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            TrieNode current = root;
            int val = arr[i];
            for (int j = 31; j >= 0; j--) {
                int bit = (val >> j) & 1;
                if (bit == 0) {
                    if(current.left == null) {
                        current.left = new TrieNode(bit);
                    }
                    current = current.left;
                } else {
                    if(current.right == null) {
                        current.right = new TrieNode(bit);
                    }
                    current = current.right;
                }
            }
        }
        int overllAns = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            TrieNode temp = root;
            int val = arr[i];
            int potentialAns = 0;
            for (int j = 31; j >= 0; j--) {
                int bit = (val >> j) & 1;
                if (bit == 0) {
                    if (temp.right != null) {
                        temp = temp.right;
                        potentialAns += (int) Math.pow(2, j);
                    } else {
                        temp = temp.left;
                    }
                } else {
                    if (temp.left != null) {
                        temp = root.left;
                        potentialAns += (int) Math.pow(2, j);
                    } else {
                        temp = temp.right;
                    }
                }
            }
            if (potentialAns > overllAns) {
                overllAns = potentialAns;
            }
        }
        System.out.println(overllAns);
    }

}
