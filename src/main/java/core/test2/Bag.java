package core.test2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("bag")//이름을 명시
public class Bag {
	private Book book;
	
	public Bag() {
		
	}
	
	@Autowired
	public Bag(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "Bag [book=" + book + "]";
	}
	
	//@Autowired // dependency에 주입하라는 명령
	public void setBook(Book book) {
		this.book = book;
	}
}
