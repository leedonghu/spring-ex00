package core.test2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App2 {
	public static void main(String[] args) {
		System.out.println("프로그램 실행");
		
		String path = "core/test2/core-test2.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(path);
		
		Object o1 = context.getBean("bag");//어노테이션에 이름을 명시하면 그 이름으로 빈이 생성됨
		Object o2 = context.getBean("book");//이름을 생략하면 클래스의 이름을 소문자로 시작한 것과 같은 빈이 생성됨
		
		System.out.println(o1);
		System.out.println(o2);
	}
}
