package com.sensitive.word;

import java.util.HashMap;
import java.util.Map;

public class TreeNode {
  public TreeNode(char chat) {
    this.chat = chat;
  }

  public transient char chat;
  public String word;
  public boolean isEnd = false;
  public Map<Character, Map<Character, TreeNode>> tree = new HashMap<Character, Map<Character, TreeNode>>();

  public static TreeNode initNode(String[] keys) {
    TreeNode root = new TreeNode('-');
    for (int i = 0; i < keys.length; i++) {
      String key = keys[i];
      char[] chats = key.toCharArray();
      TreeNode rootNode = root;
      for (int j = 0; j < chats.length; j++) {
        rootNode = insert(chats.length == j + 1, rootNode, chats[j], key);
      }
    }
    return root;
  }

  private static TreeNode insert(boolean isEnd, TreeNode rootNode, char chat, String word) {
    if (isEnd) {
      TreeNode end = new TreeNode(chat);
      end.isEnd = true;
      Map<Character, TreeNode> map = rootNode.tree.get(chat);
      if (map == null) {
        map = new HashMap<Character, TreeNode>();
      }
      end.word = word;
      map.put(end.chat, end);
      rootNode.tree.put(chat, map);
      return end;
    } else {
      Map<Character, TreeNode> map = rootNode.tree.get(chat);
      if (map == null) {
        map = new HashMap<Character, TreeNode>();
        TreeNode node = new TreeNode(chat);
        map.put(node.chat, node);
        rootNode.tree.put(chat, map);
        return node;
      } else {
        return map.get(chat);
      }

    }
  }
}
