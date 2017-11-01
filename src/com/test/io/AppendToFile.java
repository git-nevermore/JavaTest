package com.test.io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 将内容追加到文件尾部
 * @author chenwenjie
 * @since 2017-11-01
 */
public class AppendToFile {
	
	public static void main(String[] args) throws IOException {
		String fileName = "E:/file.txt";
		String content = "\n#增加的文件内容";
		appendFileByRandomAccess(fileName, content);
		appendFileByFileWriter(fileName, content);
		
		ReadFromFile.readFileByChars(fileName);
	}
	
	/**
	 * 使用 RandomAccess 追加文件内容
	 * @throws IOException 
	 */
	public static void appendFileByRandomAccess(String fileName,String content) throws IOException {
		RandomAccessFile random = new RandomAccessFile(fileName,"rw");
		long length = random.length();
		// 将文件指针移到末尾,写入内容
		random.seek(length);
		random.write(content.getBytes());
		// random.writeChars(content);	// 直接写入会出现中文字符乱码
		random.close();
	}
	
	/**
	 * 使用 FileWriter 追加文件内容
	 * @throws IOException 
	 */
	public static void appendFileByFileWriter(String fileName,String content) throws IOException {
		// true 表示以追加形式写入,而不是覆盖
		FileWriter writer = new FileWriter(fileName, true);
		writer.write(content);
		writer.close();
	}
}
