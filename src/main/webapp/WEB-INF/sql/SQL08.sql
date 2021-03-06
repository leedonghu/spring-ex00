use spr1;

CREATE TABLE tbl_member
(
userid VARCHAR(50) PRIMARY KEY,
userpw VARCHAR(100) not NULL,
username VARCHAR(100) not null,
regdate TIMESTAMP DEFAULT now(),
updateDate TIMESTAMP DEFAULT now(),
enabled TINYINT(1) DEFAULT 1
);

CREATE table tbl_member_auth
(
id int PRIMARY KEY AUTO_INCREMENT,
userid VARCHAR(50) not null,
auth VARCHAR(50) not null,
FOREIGN KEY (userid) REFERENCES tbl_member(userid)
); 

SELECT * from tbl_member;
select * from tbl_member_auth;

	SELECT 
	m.userid userid,
	m.userpw userpw,
	m.username username,
	m.enabled enabled,
	m.regdate regdate,
	m.updateDate updateDate,
	a.auth auth
	FROM tbl_member m LEFT JOIN tbl_member_auth a ON m.userid = a.userid
	WHERE m.userid = 'admin';