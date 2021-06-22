package core.test3;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary //다른 class에 injection될때 먼저 injection 되라는 어노테이션
public class FireSword implements Sword {

}
