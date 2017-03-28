package com.sensitive.word;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class WordParser {

  private LinkedList<WordToken> wordTokens = new LinkedList<WordToken>();
  private String content;
  public WordParser search(String word, TreeNode root) {
    this.content=word;
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
            wordToken.word = node.getWord();
            wordTokens.add(wordToken);
          }
          if(node.isOver()){
//            i += node.word.length();
            i++;
            node = root;
            count = 0;
          }

        }
      }
    }
    return this;
  }

  private TreeNode findNode(TreeNode node, char chat) {
     return node.tree.get(chat);
  }


  public String process() {
    StringBuilder builder = new StringBuilder(this.content);
    WordToken token=null;
    if(!wordTokens.isEmpty()){
       token=wordTokens.removeLast();
    }
    while(token!=null){
      if(builder.length()>=token.end()){
        builder.replace(token.pos, token.end(), "*");
      }
      token=null;
      if(!wordTokens.isEmpty()){
        token=wordTokens.removeLast();
      }
    }
    return builder.toString();
  }

  /**
   * 解析敏感词Token
   * @param str
   * @param node
   * @return
   */
  public LinkedList<WordToken>parser(String str,TreeNode node){
    search(str,node);
    return wordTokens;
  }
  class WordToken {
    public String word;
    public int pos = -1;

    public int end() {
      return pos + word.length();
    }

    @Override
    public String toString() {
      return "{word:"+word+",pos:"+pos+",end:"+end()+"}";
    }

    public boolean equals(String str) {
      return this.word.equals(str);
    }
  }

}
