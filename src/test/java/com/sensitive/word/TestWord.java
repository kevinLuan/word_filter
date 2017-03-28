package com.sensitive.word;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by kevin on 17/3/27.
 */
public class TestWord {
    //匹配文本
    String str="最近搞到一本黄色小说，《维奥莱特罗曼史》，习作者马努里伯爵夫人-习大-习大大";
    //敏感词
    String[] keywords =new String[]{"黄色","黄","习","习大大","习大","中国"};
    @Test
    public void test(){
        TreeNode root= TreeNode.markNode(keywords);
        WordFilter filterService = new WordFilter(root);
        System.out.println("--------------解析存在的敏感词--------------");
        LinkedList<WordParser.WordToken> list= filterService.parser(str);
        for(WordParser.WordToken token:list){
            System.out.println(token);
        }
        Assert.assertEquals(8,list.size());
    }
    @Test
    public void test1(){
        TreeNode root= TreeNode.markNode(keywords);
        WordFilter filterService = new WordFilter(root);
        System.out.println("--------------过滤敏感词--------------");
        System.out.println(filterService.filter(str));
        Assert.assertEquals("最近搞到一本*小说，《维奥莱特罗曼史》，*作者马努里伯爵夫人-*-*",filterService.filter(str));
    }
}
