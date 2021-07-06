package sample.junit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import practice.account.mapper.AccountMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class Test2 {

	@Setter (onMethod_ = @Autowired)
	private AccountMapper mapper;
	@Test
	public void test() {
		assertFalse(mapper.checkId("ukaauh3t"));
		assertTrue(mapper.checkId("asd"));
	}

}
