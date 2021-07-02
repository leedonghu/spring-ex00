use spr1;

CREATE TABLE tbl_tx_test1
(
name VARCHAR(5)
);

INSERT INTO tbl_tx_test1 (name) VALUES('abcdef');

SELECT * FROM tbl_tx_test1;
DELETE FROM tbl_tx_test1;

-- 게시물 번호로 댓글 지우기
DELETE FROM tbl_reply;
-- WHERE bno = #{bno}

select * FROM tbl_board;
select * FROM tbl_reply;

DESC tbl_board;
DESC tbl_reply;

