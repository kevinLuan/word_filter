package com.sensitive.word;


import java.util.LinkedList;
import java.util.List;

public class WordFilter {
  private TreeNode root = null;

  public WordFilter(TreeNode treeNode) {
    root = treeNode;
  }

  public String filter(String content) {
    WordParser treeNode = new WordParser();
    return treeNode.search(content, root).process();
  }

  /**
   * 解析存在的敏感词
   * @param str 文本
   * @return 存在的敏感词token
   */
  public LinkedList<WordParser.WordToken> parser(String str){
    WordParser wordParser=new WordParser();
    return wordParser.parser(str,root);
  }
  public TreeNode getNode() {
    return this.root;
  }
}
