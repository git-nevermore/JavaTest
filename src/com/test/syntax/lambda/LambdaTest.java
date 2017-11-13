package com.test.syntax.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import org.junit.Test;

import com.test.bean.Hobby;
import com.test.bean.Runner;

/**
 * Java 8 Lambda 表达式测试
 * 1.使用Lambda 表达式替换匿名类  ,必须使用函数式接口 @FunctionInterface [有且只能有一个抽象方法]
 * <p>Example :{@link java.lang.Runnable} 
 * 
 * 2.使用Lambda 表达式进行遍历
 * 
 * 3.使用 Lambda 表达式和函数式接口Predicate 实现字符串过滤
 * 
 * @author chenwenjie
 * @since 2017-10-17
 */
public class LambdaTest {
	
	/**
	 * 使用Lambda 表达式替换匿名类
	 */
	@Test
	public void runnableTest() {
		// Before:
		new Thread(new Runnable() {
		    @Override
		    public void run() {
		    	System.out.println("Before Java8, too much code for too little to do");
		    }
		}).start();
		
		// Lambda Expression:
		new Thread(() -> System.out.println("In Java8, Lambda expression rocks !!") ).run();
		
		// Before:
		new Hobby() {
			@Override
			public void running() {
				System.out.println("匿名类实现: Hobby : running");
			};
		}.running();
		
		// Lambda Expression:
		new Runner(() -> System.out.println("Java 8方式: 执行 Hobby running ") ).running();
	}
	
	/**
	 * 使用Lambda 表达式进行遍历
	 */
	@Test
	public void forEachTest() {
		// Before
		List<String> list = Arrays.asList("123","abc","456","bcd");
		for (String str : list) {
			System.out.print(str + " ");
		}
		System.out.println();
		
		// Lambda Expression:
		list.forEach(str -> System.out.print(str + " "));
		
		// 也可以使用：
		list.forEach(System.out::print);
	}
	
	/**
	 * 使用 Lambda 表达式和函数式接口Predicate 实现字符串过滤
	 */
	@Test
	public void predicateTest() {
		List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
		
		System.out.println("Languages which starts with J ");
		filter(languages, (str) -> str.startsWith("J"));
	}

	public static void filter(List<String> names, Predicate<String> condition) {
		for (String name : names) {
			if (condition.test(name)) {
				System.out.println(name + " ");
			}
		}
	}
}
