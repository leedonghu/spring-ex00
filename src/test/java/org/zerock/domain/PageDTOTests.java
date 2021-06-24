package org.zerock.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PageDTOTests {

	@Test
	public void test() {
		Criteria cri = new Criteria(1, 10);
		PageDTO p1 = new PageDTO(cri, 10);
		
		assertEquals(10, p1.getEndPage());
		assertEquals(10, new PageDTO(new Criteria(2,10), 10).getEndPage());
	}

}
