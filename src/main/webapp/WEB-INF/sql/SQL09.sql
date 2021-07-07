
create table persistent_logins (
    username varchar(64) not null,
    series varchar(64) primary key,
    token varchar(64) not null,
    last_used timestamp not null
);
SELECT * FROM tbl_board;
SELECT * FROM tbl_reply;
SELECT * FROM tbl_member;

UPDATE tbl_board
SET writer = 'member';

UPDATE tbl_reply
SET replyer = 'member';
desc persistent_logins;

ALTER TABLE tbl_board
ADD FOREIGN KEY (writer) REFERENCES tbl_member(userid);

ALTER TABLE tbl_reply
ADD FOREIGN KEY (replyer) REFERENCES tbl_member(userid);

SELECT
        b.bno bno,
        b.title title,
        b.content content,
        b.writer writer,
        b.regdate regdate,
        b.updatedate updateDate,
        m.username writerName,
    	count(r.rno) replyCnt
    FROM tbl_board b LEFT JOIN tbl_reply r ON b.bno = r.bno
    JOIN tbl_member m on b.writer = m.userid;