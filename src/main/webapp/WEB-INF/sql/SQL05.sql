SELECT b.bno, b.title, b.content, b.writer, b.regdate, b.updatedate, count(r.rno) 
FROM tbl_board b LEFT JOIN tbl_reply r ON b.bno = r.bno
GROUP BY b.bno
LIMIT 10, 10;
ORDER BY b.bno DESC;

SELECT * FROM Account;