package core.test3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Hero {
	
	// interface를 dependency를 가짐
	// interface를 구현하는 여러개의 클래스가 존재할 수 있음
	// controller가 service interface를 dependency로 가지고 있으면 service를 구현하는 여러 클래스를 주입할 수 있음
	private Sword sword;
	
	// sword에는 여러가지 클래스가 들어갈 수 있음(ex: fireSword, waterSword)
	@Autowired
//	@Qualifier("waterSword") 먼저 주입 받는 것을 명시
	public void setSword(Sword sword) {
		this.sword = sword;
	}
	
	public Sword getSword() {
		return sword;
	}
}
