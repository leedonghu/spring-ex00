package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;

public interface BoardMapper {
	
	//@Select("SELECT * FROM tbl_board")
	public List<BoardVO> getList();
	
	
	//INSERT INTO tbl_board (title, content, writer) 
	//VALUES (#{title}, #{content}, #{writer} )
	public int insert(BoardVO board);
	
	/*
	 String sql = "INSERT INTO tbl_board (title, content, writer) VALUES (?,?,?) ";
	 ...
	 pstmt.setString(1, board.getTitle());
	 ...
	 pstmt.executeUpdate(); 
	 
	 */
	
	public int insertSelectKey(BoardVO board);
	
	//하나의 record만 얻어오는 method
	public BoardVO read(long bno);
	
	public int delete(long bno);
	
	public int update(BoardVO board);
}
