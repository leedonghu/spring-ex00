use spr1;

DESC tbl_board;
SELECT * FROM tbl_board_file;


CREATE TABLE tbl_board_file
(
id INT PRIMARY KEY AUTO_INCREMENT,
bno INT REFERENCES tbl_board(bno),
fileName VARCHAR(200) NOT NULL

);
DELETE FROM tbl_board_file;

ALTER TABLE tbl_board_file
ADD FOREIGN KEY (bno) REFERENCES tbl_board(bno);

DESC tbl_board_file;