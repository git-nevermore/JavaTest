package com.test.syntax.optional;

import java.util.Optional;

import org.junit.Test;

import com.test.bean.User;

/**
 * Optional 是Java 8 引入的操作类工具库,旨在于使代码更加简化和优雅
 * 
 * @see java.util.Optional
 * @author chenwenjie
 * @since 2017-11-06
 */
public class OptionalTest {

	@Test
	public void optionalTest() {
		// 使用工厂方法构建 Optional 操作对象
		User user = new User("user", "password");
		Optional<User> opUser = Optional.of(user);
		Optional<User> empty = Optional.ofNullable(null);

		// 基本方法测试
		System.out.println(empty.isPresent());
		System.out.println(empty.orElse(new User("default", "default")));
		System.out.println(opUser.get());

		// 使用 map 等进行条件判断
		String name1 = opUser.map(u -> u.getUsername())
				.map(u -> u.toUpperCase())
				.orElse(null);

		// 相当于调用如下操作
		String name2 = operateName(user);
		System.out.println(name1);
		System.out.println(name2);

	}

	private String operateName(User user) {
		if (user != null) {
			String name2 = user.getUsername();
			if (name2 != null) {
				name2 = name2.toUpperCase();
			}
			return name2;
		} else {
			return null;
		}
	}
}
