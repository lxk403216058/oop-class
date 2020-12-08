import static org.junit.Assert.*;

import org.junit.Test;

public class test1 {

	@Test
	public void test1() {
		NextDate nextDate = new NextDate();
		String aa = nextDate.nextdate(2007, 7, 15);
		assertEquals("2007 7 16", aa);
	}
	@Test
	public void test2() {
		NextDate nextDate = new NextDate();
		String aa = nextDate.nextdate(2007, 7, 31);
		assertEquals("2007 8 1", aa);
	}
	@Test
	public void test3() {
		NextDate nextDate = new NextDate();
		String aa = nextDate.nextdate(2007, 6, 15);
		assertEquals("2007 6 16", aa);
	}
	@Test
	public void test4() {
		NextDate nextDate = new NextDate();
		String aa = nextDate.nextdate(2007, 6, 30);
		assertEquals("2007 7 1", aa);
	}
	@Test
	public void test5() {
		NextDate nextDate = new NextDate();
		String aa = nextDate.nextdate(2007, 6, 31);
		assertEquals("输入日期非法", aa);
	}
	@Test
	public void test6() {
		NextDate nextDate = new NextDate();
		String aa = nextDate.nextdate(2007, 2, 15);
		assertEquals("2007 2 16", aa);
	}
	@Test
	public void test7() {
		NextDate nextDate = new NextDate();
		String aa = nextDate.nextdate(2007, 2, 15);
		assertEquals("2007 2 16", aa);
	}
	@Test
	public void test8() {
		NextDate nextDate = new NextDate();
		String aa = nextDate.nextdate(2000, 2, 28);
		assertEquals("2000 2 29", aa);
	}
	@Test
	public void test9() {
		NextDate nextDate = new NextDate();
		String aa = nextDate.nextdate(2007, 2, 28);
		assertEquals("2007 3 1", aa);
	}
	@Test
	public void test10() {
		NextDate nextDate = new NextDate();
		String aa = nextDate.nextdate(2000, 2, 29);
		assertEquals("2000 3 1", aa);
	}
	@Test
	public void test11() {
		NextDate nextDate = new NextDate();
		String aa = nextDate.nextdate(2007, 2, 29);
		assertEquals("输入日期非法", aa);
	}
	@Test
	public void test12() {
		NextDate nextDate = new NextDate();
		String aa = nextDate.nextdate(2007, 2, 30);
		assertEquals("输入日期非法", aa);
	}
	@Test
	public void test13() {
		NextDate nextDate = new NextDate();
		String aa = nextDate.nextdate(2007, 12, 15);
		assertEquals("2007 12 16", aa);
	}
	@Test
	public void test14() {
		NextDate nextDate = new NextDate();
		String aa = nextDate.nextdate(2007, 12, 31);
		assertEquals("2008 1 1", aa);
	}

}
