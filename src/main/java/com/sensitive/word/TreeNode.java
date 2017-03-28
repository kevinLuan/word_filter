package com.sensitive.word;

import java.util.HashMap;
import java.util.Map;

public class TreeNode {
  private TreeNode() {
  }

  /**
   * 敏感词
   */
  private String word;
  /**
   * 是否结束
   */
  public boolean isEnd = false;
  public Map<Character, TreeNode> tree = new HashMap<Character,TreeNode>();

  /**
   * 初始化数据结构
   * @param keys 敏感词库
   * @return
   */
  public static TreeNode markNode(String[] keys) {
    final TreeNode root = new TreeNode();
    for (int i = 0; i < keys.length; i++) {
      String word = keys[i];
      char[] chats = word.toCharArray();
      TreeNode thisNode = root;
      for (int j = 0; j < chats.length; j++) {
        boolean isEnd=chats.length == j + 1;
        thisNode = insert(isEnd, thisNode, chats[j], word);
      }
    }
    return root;
  }

  private static TreeNode insert(boolean isEnd, TreeNode rootNode, char chat, String word) {
    if (isEnd) {
      TreeNode node = rootNode.tree.get(chat);
      if (node == null) {
        node = new TreeNode();
      }
      node.isEnd=true;
      node.word=word;
      rootNode.tree.put(chat,node);
      return node;
    } else {
      TreeNode node = rootNode.tree.get(chat);
      if (node == null) {
        node = new TreeNode();
        rootNode.tree.put(chat, node);
        return node;
      } else {
        return rootNode.tree.get(chat);
      }

    }
  }

    public boolean isOver() {
        return tree.size()==0;
    }

    public String getWord(){
      return this.word;
    }

}
