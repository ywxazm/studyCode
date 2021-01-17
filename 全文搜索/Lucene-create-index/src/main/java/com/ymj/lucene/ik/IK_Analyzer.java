package com.ymj.lucene.ik;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.lucene
 * @date 2020/8/24 14:05
 * @description
 */
public class IK_Analyzer {

    public static void main(String[] args) throws IOException {
        //创建一个标准分析器对象
        IKAnalyzer analyzer = new IKAnalyzer();
        //获得tokenStream对象
        //第一个参数：域名，可以随便给一个
        //第二个参数：要分析的文本内容
        TokenStream tokenStream = analyzer.tokenStream("test", "The Spring Framework 中华人民共和国,地我 provides a comprehensive programming and configuration model.");
        //添加一个引用，可以获得每个关键词
        CharTermAttribute charTermAttribute = tokenStream.addAttribute(CharTermAttribute.class);
        //添加一个偏移量的引用，记录了关键词的开始位置以及结束位置
        OffsetAttribute offsetAttribute = tokenStream.addAttribute(OffsetAttribute.class);
        //将指针调整到列表的头部
        tokenStream.reset();
        //遍历关键词列表，通过incrementToken方法判断列表是否结束
        while(tokenStream.incrementToken()) {
            //关键词的起始位置
            System.out.print("start index = " + offsetAttribute.startOffset() + ", ");
            //取关键词
            System.out.print("word = " + charTermAttribute + ", ");
            //结束位置
            System.out.println("end index = " + offsetAttribute.endOffset());
        }
        tokenStream.close();
    }

}