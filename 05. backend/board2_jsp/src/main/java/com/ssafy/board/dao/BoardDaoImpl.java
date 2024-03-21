package com.ssafy.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.board.model.BoardDto;
import com.ssafy.util.DBUtil;

public class BoardDaoImpl implements BoardDao {
	private static BoardDao instance = new BoardDaoImpl();
	
	public static BoardDao getInstance() {
		return instance;
	}
	
	private BoardDaoImpl() {}
	
	@Override
	public int writeArticle(BoardDto boardDto) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil.getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append("insert into board(user_id, subject, content) \n");
			sql.append("values(?,?,?) \n");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, boardDto.getUserId());
			pstmt.setString(2, boardDto.getSubject());
			pstmt.setString(3, boardDto.getContent());
			
			cnt = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt, conn);
		}
		
		return cnt;
	}

	@Override
	public List<BoardDto> listArticle() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<BoardDto> list = new ArrayList<>();
		
		try {
			conn = DBUtil.getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append("select * \n");
			sql.append("from board \n");
			sql.append("order by register_time desc \n");
			
			pstmt = conn.prepareStatement(sql.toString());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDto boardDto = new BoardDto();
				
				boardDto.setArticleNo(rs.getInt("article_no"));
				boardDto.setUserId(rs.getString("user_id"));
				boardDto.setSubject(rs.getString("subject"));
				boardDto.setContent(rs.getString("content"));
				boardDto.setHit(rs.getInt("hit"));
				boardDto.setRegisterTime(rs.getString("register_time"));
				
				list.add(boardDto);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt, conn);
		}
		
		return list;
	}

	@Override
	public BoardDto viewArticle(int articleNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<BoardDto> list = new ArrayList<>();
		
		try {
			conn = DBUtil.getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append("select * \n");
			sql.append("from board \n");
			sql.append("where article_no=? \n");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, articleNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDto boardDto = new BoardDto();
				
				boardDto.setArticleNo(rs.getInt("article_no"));
				boardDto.setUserId(rs.getString("user_id"));
				boardDto.setSubject(rs.getString("subject"));
				boardDto.setContent(rs.getString("content"));
				boardDto.setHit(rs.getInt("hit"));
				boardDto.setRegisterTime(rs.getString("register_time"));
				
				return boardDto;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt, conn);
		}
		
		return null;
	}
	
	@Override
	public void updateArticle(BoardDto boardDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil.getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append("update board set subject=?,content=?where article_no=?\n");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, boardDto.getSubject());
			pstmt.setString(2, boardDto.getContent());
			pstmt.setInt(3, boardDto.getArticleNo());
			
			pstmt.executeUpdate();

			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt, conn);
		}
		
	}
 
	
	@Override
	public void deleteArticle(int articleNo) {
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		int rs; 

		try {
			conn=DBUtil.getConnection();
			
			StringBuilder sql=new StringBuilder();
			sql.append("delete from board where article_no=?\n");
			
			pstmt=conn.prepareStatement(sql.toString());
			pstmt.setInt(1, articleNo); //첫번째 ?에 articleNo 넣는다
			
			rs=pstmt.executeUpdate(); //삭제의 경우 executeQuery()가 아닌 executeUpdate()를 사용해야한다!!!!!성공하면 1, 실패하면 0
			
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt, conn);
		}
	}

	@Override
	public void updateHit(int articleNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil.getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append("update board set hit=hit+1 where article_no=?\n");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, articleNo);
			
			pstmt.executeUpdate();

			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt, conn);
		}
		
	}

}

/* @see: template code
  
 
	@Override
	public int writeArticle(BoardDto boardDto) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append(" \n");
			sql.append(" \n");
			sql.append(" \n");
			sql.append(" \n");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, null);
			pstmt.setString(2, null);
			pstmt.setString(3, null);
			
			cnt = pstmt.executeUpdate();
		
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String data1 = rs.getString("data1-column-name");
				int data2 = rs.getInt("data2-column-name");
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt, conn);
		}
		
		return cnt;
	}

*/