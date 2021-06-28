package practice.account.domain;

import java.util.Date;

import lombok.Data;

@Data
public class AccountVO {
	
	private String name;
	private String id;
	private String password;
	private String mobileNum;
	private String email;
	private String address;
	private Date birth;
	private Date regdate;
}
