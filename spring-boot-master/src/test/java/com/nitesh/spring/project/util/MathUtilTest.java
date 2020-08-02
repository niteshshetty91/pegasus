package com.nitesh.spring.project.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MathUtilTest {

	@Test
	void test1() {

		String expected = "4.0";
		String actual = MathUtil.evaluate("(4-2)*2");

		assertEquals(expected, actual);

	}

	@Test
	void test2() {

		String expected = "6.0";
		String actual = MathUtil.evaluate("(4-1)*2");

		assertEquals(expected, actual);

	}


}
