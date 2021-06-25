package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface Test2Mapper {
	
	// type 그 자체를 쓰고싶으면 앞에 param 어노테이션을 붙임
	// 안붙이면 xml파일에서 #{type}이라고 썼을때 type.getType();이 실행됨
	public int sql1(@Param("type")String type);
	
	public int sql2(@Param("type") String t);
	
	public int sql3(@Param("type") String a);
	
	public int sql4(@Param("type") String t);
	
	public int sql5(@Param("type") String t);
	
	public int sql6(@Param("list")List<String> types);
	
	public int sql7(@Param("list")List<String> types);
}
