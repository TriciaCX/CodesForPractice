package interviewTop100;

public class leetcode208
{
	class Trie {
	    private final int SIZE = 26;
	    private TrieNode root;
	    // TrieNode 
	    class TrieNode {
	        // 多少单词通过这个节点,即由根至该节点组成的字符串模式出现的次数
	        private int num;
	        // 所有的儿子节点
	        private TrieNode[] son;
	        // 是不是最后一个节点
	        private boolean isEnd;
	        // 节点自身的值
	        private char val;
	        TrieNode() {
	            num = 1;
	            son = new TrieNode[SIZE];
	            isEnd = false;
	        }
	    }

	    /** Initialize your data structure here. */
	    public Trie() {
	        root = new TrieNode();
	    }
	    
	    /** Inserts a word into the trie. */
	    public void insert(String word) {
	        if (word == null || word.length() == 0) {
	            return;
	        }
	        char[] chars = word.toCharArray();
	        int len = chars.length;
	        TrieNode node = root;
	        for (int i = 0; i < len; i++) {
	            int pos = chars[i] - 'a';
	            if (node.son[pos] == null) {
	                node.son[pos] = new TrieNode();
	                node.son[pos].val = chars[i];
	            } else {
	                node.son[pos].num++;
	            }
	            node = node.son[pos];
	        }
	        node.isEnd = true;
	    }
	    
	    /** Returns if the word is in the trie. */
	    public boolean search(String word) {
	        if (word == null || word.length() == 0) {
	            return false;
	        }
	        TrieNode node = root;
	        char[] letters = word.toCharArray();
	        for (int i = 0, len = word.length(); i < len; i++) {
	            int pos = letters[i] - 'a';
	            if (node.son[pos] != null) {
	                node = node.son[pos];
	            }
	            else {
	                return false;
	            }
	        }
	        return node.isEnd;
	    }
	    
	    /** Returns if there is any word in the trie that starts with the given prefix. */
	    public boolean startsWith(String prefix) {
	        if (prefix == null || prefix.length() == 0) {
	            return false;
	        }
	        TrieNode node = root;
	        char[] letters = prefix.toCharArray();
	        int len = letters.length;
	        for (int i = 0; i < len; i++) {
	            int pos = letters[i] - 'a';
	            if (node.son[pos] == null) {
	                return false;
	            } else {
	                node = node.son[pos];
	            }
	        }
	        return true;
	    }
	}

}
