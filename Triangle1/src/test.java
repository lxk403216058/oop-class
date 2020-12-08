import static org.junit.Assert.*;

import org.junit.Test;

public class test {

	@Test
	public void test() {
		Triangle triangle=new Triangle();
		String result = triangle.type(100, 100, 100);
		assertEquals("等边三角形", result);
	}
	@Test
	public void test1() {
		Triangle triangle=new Triangle();
		String result = triangle.type(0, 100, 100);
		assertEquals("输入非法", result);
	}
	@Test
	public void test2() {
		Triangle triangle=new Triangle();
		String result = triangle.type(1, 100, 100);
		assertEquals("等腰三角形", result);
	}
	@Test
	public void test3() {
		Triangle triangle=new Triangle();
		String result = triangle.type(2, 100, 100);
		assertEquals("等腰三角形", result);
	}
	@Test
	public void test4() {
		Triangle triangle=new Triangle();
		String result = triangle.type(199, 100, 100);
		assertEquals("等腰三角形", result);
	}
	@Test
	public void test5() {
		Triangle triangle=new Triangle();
		String result = triangle.type(200, 100, 100);
		assertEquals("非三角形", result);
	}
	@Test
	public void test6() {
		Triangle triangle=new Triangle();
		String result = triangle.type(201, 100, 100);
		assertEquals("输入非法", result);
	}
	@Test
	public void test7() {
		Triangle triangle=new Triangle();
		String result = triangle.type(100, 0, 100);
		assertEquals("输入非法", result);
	}
	@Test
	public void test8() {
		Triangle triangle=new Triangle();
		String result = triangle.type(100, 1, 100);
		assertEquals("等腰三角形", result);
	}
	@Test
	public void test9() {
		Triangle triangle=new Triangle();
		String result = triangle.type(100, 2, 100);
		assertEquals("等腰三角形", result);
	}
	@Test
	public void test10() {
		Triangle triangle=new Triangle();
		String result = triangle.type(100, 199, 100);
		assertEquals("等腰三角形", result);
	}
	@Test
	public void test11() {
		Triangle triangle=new Triangle();
		String result = triangle.type(100, 200, 100);
		assertEquals("非三角形", result);
	}
	@Test
	public void test12() {
		Triangle triangle=new Triangle();
		String result = triangle.type(100, 201, 100);
		assertEquals("输入非法", result);
	}
	@Test
	public void test13() {
		Triangle triangle=new Triangle();
		String result = triangle.type(100, 100, 0);
		assertEquals("输入非法", result);
	}
	@Test
	public void test14() {
		Triangle triangle=new Triangle();
		String result = triangle.type(100, 100, 1);
		assertEquals("等腰三角形", result);
	}
	@Test
	public void test15() {
		Triangle triangle=new Triangle();
		String result = triangle.type(100, 100, 2);
		assertEquals("等腰三角形", result);
	}
	@Test
	public void test16() {
		Triangle triangle=new Triangle();
		String result = triangle.type(100, 100, 199);
		assertEquals("等腰三角形", result);
	}
	@Test
	public void test17() {
		Triangle triangle=new Triangle();
		String result = triangle.type(100, 100, 200);
		assertEquals("非三角形", result);
	}
	@Test
	public void test18() {
		Triangle triangle=new Triangle();
		String result = triangle.type(100, 100, 201);
		assertEquals("输入非法", result);
	}

}
