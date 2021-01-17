package com.ymj.lucene;

import org.apache.commons.io.FileUtils;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.lucene
 * @date 2020/8/24 11:41
 * @description
 */
public class CreateIndex {

    public static void main(String[] args) throws IOException {
        //指定索引库存放的路径
        Directory directory = FSDirectory.open(new File("C:\\Users\\2402\\Desktop").toPath());
        //索引库还可以存放到内存中
        //Directory directory = new RAMDirectory();
        //创建indexwriterCofig对象
        IndexWriterConfig config = new IndexWriterConfig();
        //创建indexwriter对象
        IndexWriter indexWriter = new IndexWriter(directory, config);
        //原始文档的路径
        File dir = new File("D:\\study\\study-code\\全文搜索\\file");
        File[] files = dir.listFiles();
        for (File f : Objects.requireNonNull(files)) {
            //文件名
            String fileName = f.getName();
            //文件内容
            String fileContent = FileUtils.readFileToString(f);
            //文件路径
            String filePath = f.getPath();
            //文件的大小
            long fileSize  = FileUtils.sizeOf(f);
            //创建文件名域
            //第一个参数：域的名称
            //第二个参数：域的内容
            //第三个参数：是否存储
            Field fileNameField = new TextField("filename", fileName, Field.Store.YES);
            //文件内容域
            Field fileContentField = new TextField("content", fileContent, Field.Store.YES);
            //文件路径域（不分析、不索引、只存储）
            Field filePathField = new TextField("path", filePath, Field.Store.YES);
            //文件大小域
            Field fileSizeField = new TextField("size", fileSize + "", Field.Store.YES);

            //创建document对象
            Document document = new Document();
            document.add(fileNameField);
            document.add(fileContentField);
            document.add(filePathField);
            document.add(fileSizeField);
            //创建索引，并写入索引库
            indexWriter.addDocument(document);
        }
        //关闭indexwriter
        indexWriter.close();

    }
}