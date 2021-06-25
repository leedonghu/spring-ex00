SELECT * FROM tbl_board
ORDER BY bno DESC;

-- 제목 검색
SELECT * FROM tbl_board
WHERE title LIKE '%1%'
ORDER BY bno DESC
LIMIT 0, 10;

-- 제목 본문 검색
SELECT * FROM tbl_board
WHERE title LIKE '%1%'
OR content LIKE '%1%'
ORDER BY bno DESC
LIMIT 0, 10;

-- 제목 본문 작성자 검색
SELECT * FROM tbl_board
WHERE title LIKE '%1%'
OR content LIKE '%1%'
OR writer LIKE '%동%'
ORDER BY bno DESC
LIMIT 0, 10;

-- CONCAT() 함수
SELECT concat('A','B');
