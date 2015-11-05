package com.sensitive.word;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class WordParser {

  private List<WordToken> wordTokens = new ArrayList<WordToken>();

  public void search(String word, TreeNode root) {
    char[] chats = word.toCharArray();
    TreeNode node = root;
    int count = 0;
    for (int i = 0; i < chats.length;) {
      char chat = chats[i + count];
      count++;
      node = findNode(node, chat);
      if (node == null) {
        node = root;
        i++;
        count = 0;
        continue;
      } else {
        if (node.isEnd) {
          {
            WordToken wordToken = new WordToken();
            wordToken.pos = i;
            wordToken.word = node.word;
            wordTokens.add(wordToken);
          }

          i += node.word.length();
          node = root;
          count = 0;

        }
      }
    }
  }

  private TreeNode findNode(TreeNode node, char chat) {
    if (node.tree.containsKey(chat)) {
      Map<Character, TreeNode> map = node.tree.get(chat);
      return map.get(chat);
    }
    return null;
  }


  public String process(String str) {
    StringBuilder builder = new StringBuilder(str);
    for (int i = wordTokens.size() - 1; i >= 0; i--) {
      WordToken token = wordTokens.get(i);
      builder.replace(token.pos, token.end(), "*");
    }
    return builder.toString();
  }

  class WordToken {
    public String word;
    public int pos = -1;

    public int end() {
      return pos + word.length();
    }
  }

}
