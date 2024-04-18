package com.ssafy.book.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.ssafy.board.model.BoardDto;
import com.ssafy.book.model.BookDto;
import com.ssafy.util.DBUtil;

@Service
public class BookDaoImpl implements BookDao{
	private DataSource dataSource;
	private DBUtil dbUtil;
	
	public BookDaoImpl(DataSource dataSource, DBUtil dbUtil) {
		super();
		this.dataSource = dataSource;
		this.dbUtil = dbUtil;
	}

	@Override
	public void registBook(BookDto bookDto) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("insert into book (isbn,author,title,price,content,img) \n");
			sql.append("values (?, ?, ?,?,?,?)");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, bookDto.getIsbn());
			pstmt.setString(2, bookDto.getAuthor());
			pstmt.setString(3, bookDto.getTitle());
			pstmt.setInt(4, bookDto.getPrice());
			pstmt.setString(5, bookDto.getContent());
			pstmt.setString(6, bookDto.getImg());
			
			
			pstmt.executeUpdate();
		} finally {
			dbUtil.close(pstmt, conn);
		}
	}

	@Override
	public List<BookDto> listBook(Map<String, String> param) throws SQLException {
		List<BookDto> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select isbn,title,author,price from book");

			pstmt = conn.prepareStatement(sql.toString());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BookDto book=new BookDto();
				book.setIsbn(rs.getString("isbn"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPrice(rs.getInt("price"));
				
				list.add(book);
			}
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return list;
	}

	@Override
	public BookDto getBook(String isbn) throws SQLException {
		BookDto book = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select * \n");
			sql.append("from book \n");
			sql.append("where isbn = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, isbn);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				book=new BookDto();
				book.setIsbn(rs.getString("isbn"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPrice(rs.getInt("price"));
				book.setImg(rs.getString("img"));
				book.setContent(rs.getString("content"));
				
			}
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return book;
	}

}
