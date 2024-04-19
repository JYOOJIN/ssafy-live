package com.ssafy.mybatis.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ssafy.mybatis.config.SqlMapConfig;
import com.ssafy.mybatis.model.MemberDto;

public class MemberDaoImpl implements MemberDao {
	
	private final String NAME_SPACE="com.ssafy.mybatis.model.dao.MemberDao";
	
	// sqlSession : Connection
	// C : insert() 
	// R : selectList(), selectOne()
	// U : update()
	// D : delete()
	
	
	
	@Override
	public void joinMember(MemberDto memberDto) throws SQLException {
		try(SqlSession sqlSession=SqlMapConfig.getSqlSession()){
			//MemberMapper의 sql문 실행. SQL문이 XML로 빠진 것
			//memberDto를 넘겨준다. 
			sqlSession.insert(NAME_SPACE+".joinMember",memberDto);
			sqlSession.commit(); //autoCommit이 아니기 때문에 commit 필수
		}
	}

	@Override
	public List<MemberDto> listMember() throws SQLException {
		try(SqlSession sqlSession=SqlMapConfig.getSqlSession()){
			//목록을 select이므로 list를 사용하고, where 절에 넣을 파라미터가 없기 때문에 statement 없다
			List<MemberDto> list=sqlSession.selectList(NAME_SPACE+".listMember");
			return list;
		}
	}

}
