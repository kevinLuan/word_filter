package com.sensitive.word;


public class WordFilter {
  private TreeNode root = null;

  public WordFilter(String keys[]) {
    root = TreeNode.initNode(keys);
  }

  public String filter(String content) {
    WordParser treeNode = new WordParser();
    treeNode.search(content, root);
    return treeNode.process(content);
  }

  public TreeNode getNode2() {
    return this.root;
  }
}
