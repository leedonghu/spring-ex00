CREATE DATABASE spr1;
USE spr1;

CREATE TABLE tbl_board
(
bno INT PRIMARY KEY AUTO_INCREMENT,
title VARCHAR(255) NOT NULL,
content VARCHAR(2000) not NULL,
writer VARCHAR(50) not NULL,
regdate TIMESTAMP DEFAULT NOW(),
updatedate TIMESTAMP DEFAULT NOW()
);

INSERT INTO tbl_board
(title, content, writer)
VALUES
('테스트 제목', '테스트 내용', 'user00');

SELECT * FROM tbl_board;