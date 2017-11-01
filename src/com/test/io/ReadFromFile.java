package com.test.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.Reader;

/**
 * 读取文件方法
 * <p>以字节为单位,每次读取一个/多个字节 
 * <p>以字符为单位,每次读取一个/多个字符
 * <p>以行为单位,每次读取一行
 * <p>从任意位置开始读取文件内容
 * 
 * @author chenwenjie
 * @since 2017-10-31
 */
public class ReadFromFile {

	public static void main(String[] args) throws IOException {
		String fileName = "E:/file.txt";
		readFileByByte(fileName);
		readFileByBytes(fileName);
		readFileByChar(fileName);
		readFileByChars(fileName);
		readFileByLine(fileName);
		readFileByRandomAccess(fileName);
	}
	
	/**
	 * 以字节为单位读取文件，常用于读二进制文件，如图片、声音、影像等文件 (一次读取一个字节)
	 * @param fileName
	 */
	public static void readFileByByte(String fileName) {
		System.out.println("按字节为单位读取文件,每次读取一个字节..");
		File file = new File(fileName);
		InputStream in = null;
		try {
			in = new FileInputStream(file);
			int temp = 0;
			StringBuilder sb = new StringBuilder();
			while ((temp = in.read()) != -1) {
				sb.append((char) temp);
			}
			System.out.print(sb.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 以字节为单位，一次读取多个字节
	 * @param fileName
	 * @throws IOException 
	 */
	public static void readFileByBytes(String fileName) throws IOException {
		System.out.println("\n按字节为单位读取文件,每次读取多个字节..");
		File file = new File(fileName);
		InputStream in = new FileInputStream(file);
		byte[] tempArray = new byte[100];
		int temp = 0;
		StringBuilder sb = new StringBuilder();
		while ((temp = in.read(tempArray)) != -1) {
			String str = new String(tempArray,0,temp);
			sb.append(str);
		}
		in.close();
		System.out.print(sb.toString());
	}
	
	/**
	 * 以字符为单位,每次读取一个字符.<p>常用与读取文本，数字等类型
	 * @param fileName
	 * @throws IOException 
	 */
	public static void readFileByChar(String fileName) throws IOException {
		System.out.println("\n按字符为单位读取文件,每次读取一个字符");
		Reader reader = new InputStreamReader(new FileInputStream(new File(fileName)));
		int temp = 0;
		StringBuilder sb = new StringBuilder();
		while ((temp = reader.read()) != -1 ) {
			if ((char) temp != '\r') {
				sb.append((char) temp);
			}
		}
		reader.close();
		System.out.print(sb.toString());
	}
	
	/**
	 * 以字符为单位,每次读取多个字符.<p>常用与读取文本，数字等类型
	 * @param fileName
	 * @throws IOException 
	 */
	public static void readFileByChars(String fileName) throws IOException {
		System.out.println("\n按字符为单位读取文件,每次读取多个字符");
		Reader reader = new InputStreamReader(new FileInputStream(new File(fileName)));
		int temp = 0;
		char[] chars = new char[30];
		StringBuilder sb = new StringBuilder();
		while ((temp = reader.read(chars)) != -1 ) {
			if (temp == chars.length && chars[chars.length-1] != '\r') {
				sb.append(chars);
			} else {
				for (int i = 0; i < chars.length; i++) {
					sb.append(chars[i]);
				}
			}
		}
		reader.close();
		System.out.print(sb.toString());
	}
	
	/**
	 * 以行为单位读取文件，常用于读面向行的格式化文件 
	 * @param fileName
	 * @throws IOException
	 */
	public static void readFileByLine(String fileName) throws IOException {
		System.out.println("\n按行为单位读取文件,每次读取一行");
		BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
		String temp = null;
		StringBuilder sb = new StringBuilder();
		while ((temp = reader.readLine()) != null ) {
			sb.append(temp);
		}
		reader.close();
		System.out.println(sb.toString());
	}
	
	/**
	 * 随机读取文件内容
	 * @param fileName
	 * @throws IOException
	 */
	public static void readFileByRandomAccess(String fileName) throws IOException {
		System.out.println("随机读取一段文件内容：");  
	    RandomAccessFile randomFile = new RandomAccessFile(fileName, "r");
        long fileLength = randomFile.length();  
        int beginIndex = (fileLength > 4) ? 4 : 0;  
        randomFile.seek(beginIndex);  
        
        byte[] bytes = new byte[10];  
        int byteread = 0;  
        StringBuilder sb = new StringBuilder();
        while ((byteread = randomFile.read(bytes)) != -1) {  
            String str = new String(bytes,0,byteread);
            sb.append(str);
        }  
        randomFile.close();
        System.out.println(sb.toString());
	}
}
