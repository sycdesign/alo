// 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
//
// 示例:
//
// Trie trie = new Trie();
//
// trie.insert("apple");
// trie.search("apple");   // 返回 true
// trie.search("app");     // 返回 false
// trie.startsWith("app"); // 返回 true
// trie.insert("app");
// trie.search("app");     // 返回 true
//
// 说明:
//
//
// 你可以假设所有的输入都是由小写字母 a-z 构成的。
// 保证所有输入均为非空字符串。
//
// Related Topics 设计 字典树
// 👍 412 👎 0

package leetcode.editor.cn;

import java.util.TreeMap;

// Java：实现 Trie (前缀树)
public class P208ImplementTriePrefixTree {
  public static void main(String[] args) {
    Trie obj = new Trie();
    obj.insert("apple");
    boolean param_1 = obj.search("apple");
    System.out.println(param_1);
    boolean param_2 = obj.search("app");
    System.out.println(param_2);
    boolean param_3 = obj.startsWith("app");
    System.out.println(param_3);
  }
  // leetcode submit region begin(Prohibit modification and deletion)

  public static class Trie {

    class TrieNode {
      public char val;
      public boolean isWord;
      public TrieNode[] children = new TrieNode[26];

      public TrieNode() {}

      TrieNode(char c) {
        TrieNode node = new TrieNode();
        node.val = c;
      }
    }

    private TrieNode root;

    public Trie() {
      root = new TrieNode();
      root.val = ' ';
    }

    public void insert(String word) {
      TrieNode ws = root;
      for (int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);
        if (ws.children[c - 'a'] == null) {
          ws.children[c - 'a'] = new TrieNode(c);
        }
        ws = ws.children[c - 'a'];
      }
      ws.isWord = true;
    }

    public boolean search(String word) {
      TrieNode ws = root;
      for (int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);
        if (ws.children[c - 'a'] == null) return false;
        ws = ws.children[c - 'a'];
      }
      return ws.isWord;
    }

    public boolean startsWith(String prefix) {
      TrieNode ws = root;
      for (int i = 0; i < prefix.length(); i++) {
        char c = prefix.charAt(i);
        if (ws.children[c - 'a'] == null) return false;
        ws = ws.children[c - 'a'];
      }
      return true;
    }
  }

  /**
   * Your Trie object will be instantiated and called as such: Trie obj = new Trie();
   * obj.insert(word); boolean param_2 = obj.search(word); boolean param_3 = obj.startsWith(prefix);
   */
  // leetcode submit region end(Prohibit modification and deletion)

}
