package com.ymj.lucene.indexLib;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.File;
import java.io.IOException;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.lucene.indexLib
 * @date 2020/8/24 14:39
 * @description
 */
public class TermQueryModel {

    public static void main(String[] args) throws IOException {
        Directory directory = FSDirectory.open(new File("C:\\Users\\2402\\Desktop").toPath());
        IndexReader indexReader = DirectoryReader.open(directory);
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);

        //创建查询对象
        Query query = new TermQuery(new Term("content", "lucene"));
        //执行查询
        TopDocs topDocs = indexSearcher.search(query, 10);
        //共查询到的document个数
        System.out.println("查询结果总数量：" + topDocs.totalHits);
        //遍历查询结果
        for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
            Document document = indexSearcher.doc(scoreDoc.doc);
            System.out.println(document.get("filename"));
            //System.out.println(document.get("content"));
            System.out.println(document.get("path"));
            System.out.println(document.get("size"));
        }
        //关闭indexreader
        indexSearcher.getIndexReader().close();
    }
}