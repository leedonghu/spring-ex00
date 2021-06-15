package core.test1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App1 {
	public static void main(String[] args) {
		System.out.println("프로그램 실행");
		
		// 객체를 설명서(xml, java)를 보고 만들어줌
		String path = "core/test1/core-test1.xml";
		
		ApplicationContext context = new ClassPathXmlApplicationContext(path);
		
		//bean을 만들었는지 확인
		//xml에서 객체 이름을 desk로 지정
		Object o = context.getBean("desk");
		System.out.println(o);
		
		Object o2 = context.getBean("leg");
		System.out.println(o2);
		
		Object o3 = context.getBean("chair");
		System.out.println(o3);
	}
}
