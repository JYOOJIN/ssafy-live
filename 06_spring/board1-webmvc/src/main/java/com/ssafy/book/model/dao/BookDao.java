package com.ssafy.book.model.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.board.model.BoardDto;
import com.ssafy.book.model.BookDto;

public interface BookDao {
	void registBook(BookDto bookDto) throws SQLException;
	List<BookDto> listBook(Map<String, String> map) throws SQLException;
	BookDto getBook(String isbn) throws SQLException;
}
