package sample.junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyTest1 {

	@Test
	public void test() {
		//fail("Not yet implemented"); // 무조건 실패하는 method
		int i = 3;
		if(i != 3) {
			fail("i는 3이 아닙니다.");
		}
	}
	
	@Test
	public void equals() {
		int i = 3;
		boolean b = true;
		Object c = null;
		
		assertEquals(i, 3); // 앞쪽의 파라미터와 뒤의 파라미터가 같으면 성공
		assertEquals(b, true);
		assertTrue(b);
		assertNull(c);
	}
	
	@Test
	public void notEquals() {
		int i = 5;
		boolean b = false;
		Object c = new Object();
		
		assertNotEquals(i, 3); // 같지 않으면 성공
		assertFalse(b);
		assertNotNull(c);
	}

}
