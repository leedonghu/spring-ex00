SELECT * FROM tbl_board
order BY bno DESC
LIMIT 0, 5;

SELECT * FROM tbl_board
order BY bno DESC
LIMIT 5, 5;

SELECT * FROM tbl_board
order BY bno DESC
LIMIT 10, 5; -- n 번째 페이지 limit  5 * (n-1) , 5

SELECT * from Cart
where customerId = 'aaaaa'
GROUP BY productName;