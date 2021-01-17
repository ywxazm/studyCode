package com.ymj.lucene.indexLib;

import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
import java.io.IOException;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.lucene.indexLib
 * @date 2020/8/24 14:36
 * @description
 */
public class DelByCondition {

    public static void main(String[] args) throws IOException {
        //索引库存放路径
        Directory directory = FSDirectory.open(new File("C:\\Users\\2402\\Desktop").toPath());
        IndexWriterConfig config = new IndexWriterConfig(new IKAnalyzer());
        IndexWriter indexWriter = new IndexWriter(directory, config);

        //创建一个查询条件
        Query query = new TermQuery(new Term("filename", "apache"));
        //根据查询条件删除
        indexWriter.deleteDocuments(query);
        //关闭indexwriter
        indexWriter.close();

    }
}