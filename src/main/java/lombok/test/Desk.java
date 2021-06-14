package lombok.test;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor // final필드만 받는 생성자
@ToString
@EqualsAndHashCode
public class Desk {
	private final double price;
	private final String model;
	private String name;
}
