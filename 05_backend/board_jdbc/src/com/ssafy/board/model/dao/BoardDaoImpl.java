package com.ssafy.board.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.board.model.BoardDto;
import com.ssafy.util.DBUtil;

/*
 * ## jdbc 프로그래밍 절차
 * 1. driver loading: driver -> factory pattern
 * 2. db 연결: url, user, password -> method 분리 설계 -> factory pattern
 * 3. 통로 개설:
 * 4. sql 수행 요청
 * 5. 결과처리
 * 6. 자원해제
 * 
 * ## db resource property
 * 1. driver : 생성자 => Factory pattern(DBUtil.java)
 * 2. url 
 * 3. user
 * 4. password
 */

/*
## Singleton Pattern
  - 단일 instance 제공
  - 설계 규칙  
(1) private 생성자()  
(2) public static 클래스 이름 getInstance(){ return instance; }  
(3) private static 클래스 이름 instance = new 클래스이름();  
(4) 사용: 직접 객체 생성 사용 불가  
 클래스이름 참조변수명 = 클래스이름.getInstance();
*/

//Factory Pattern => DBUtil
public class BoardDaoImpl implements BoardDao {
	
//	private final String DRIVER = "com.mysql.cj.jdbc.Driver";
//	private final String URL = "jdbc:mysql://localhost:3306/ssafydb?serverTimezone=UTC";
//	private final String DB_ID = "ssafy";
//	private final String DB_PWD = "ssafy";
	
	private static BoardDao boardDao = new BoardDaoImpl(); //3
	
	private BoardDaoImpl() {
//		try {
//			Class.forName(DRIVER); // 1. 드라이버 로딩
//		} catch (ClassNotFoundException e) {
//			System.out.println("드라이버 로딩 오류 발생!!!");
//			e.printStackTrace(); //디버그 시에 사용. 실제 서비스 사용 시에는 보안 이슈
//			// log 관련 framework: xml 환경설정 제어
//		}
		
	} //1
	
	public Connection getConnection() throws SQLException {
		//return DriverManager.getConnection(URL,DB_PWD, DB_ID);
		return DBUtil.getInstance().getConnection();
		
	}

	public static BoardDao getBoardDao() { //2
		return boardDao;
	}

	// 게시글 등록
	@Override
	public void registerArticle(BoardDto boardDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
//		TODO : boardDto의 내용을 board table에 insert 하세요!!!
		
		//conn=DriverManager.getConnection(URL,DB_PWD, DB_ID);
		try {
			// 2. db 연결
			conn=getConnection(); 
			// 3. 통로 개설: 전용 통로
			//String sql = "insert into board(user_id,subject,content) values(?,?,?)";
			StringBuilder sql=new StringBuilder();
			sql.append("insert into board(user_id,subject,content)");
			sql.append("values (?,?,?)");
			pstmt=conn.prepareStatement(sql.toString());
			
			// ? 매핑되는 값을 설정. index는 1번부터 시작
			pstmt.setString(1, boardDto.getUserId());
			pstmt.setString(2, boardDto.getSubject());
			pstmt.setString(3, boardDto.getContent());
			
			// 4. sql 수행요청
			// executeUpdate() : int - CUD
			// executeQuery() : ResultSet - R
			int result=pstmt.executeUpdate();
			
			// 5. 결과처리
			if(result==1) {
				System.out.println("성공-게시글 등록 완료");
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 6. 자원해제
//			try {
//				if(pstmt!=null) {
//					pstmt.close();
//				}
//				if(conn!=null) {
//					conn.close();
//				}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
			DBUtil.getInstance().close(pstmt,conn);
			
		}
//		END
	}

	//dto는 데이터를 들고 이동하는 객체
	@Override
	public List<BoardDto> searchListAll() {
		List<BoardDto> list = new ArrayList<BoardDto>();
//		TODO : board table의 모든 글정보를 글번호순으로 정렬하여 list에 담고 return 하세요!!!
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=getConnection();
			StringBuilder sql=new StringBuilder();
//			sql.append("select *\n");
//			sql.append("from board\n");
//			sql.append("order by register_time desc");
			sql.append("select * from board order by register_time desc");
			pstmt=conn.prepareStatement(sql.toString());
			// ? 없으니까 완성형 통로
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDto dto=new BoardDto();
				dto.setArticleNo(rs.getInt("article_no"));
				dto.setUserId(rs.getString("user_id"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setRegisterTime(rs.getString("register_time"));
				
				list.add(dto);
				
			}
			
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("전체 조회 오류 발생");
		}finally {
			// 자원해제
			DBUtil.getInstance().close(pstmt,conn,rs);
		}
		
//		END
		return list;
	}

	@Override
	public List<BoardDto> searchListBySubject(String subject) {
		List<BoardDto> list = new ArrayList<BoardDto>();
//		TODO : board table에서 제목에 subject를 포함하고 있는 글정보를 list에 담고 return 하세요!!!
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			conn=getConnection();
			StringBuilder sql=new StringBuilder();
			sql.append("select * from board where subject like ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, '%'+subject+'%'); //'%subject%' 반드시 싱글 쿼테이션 사용!!
			rs = pstmt.executeQuery();
	        while(rs.next()) {
	        	BoardDto dto=new BoardDto();
	        	dto.setArticleNo(rs.getInt("article_no"));
	        	dto.setUserId(rs.getString("user_id"));
	        	dto.setSubject(rs.getString("subject"));
	        	dto.setContent(rs.getString("content"));
	        	dto.setRegisterTime(rs.getString("register_time"));
	        	
	        	list.add(dto);
	        }
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("상제 조회 오류 발생");
		}finally {
			DBUtil.getInstance().close(pstmt,conn,rs);
		}
		
		
//		END
		return list;
	}

	//상세조회
	@Override
    public BoardDto viewArticle(int no) {
        BoardDto dto = null;
//        TODO : board table에서 글번호가 no인 글 한개를 return 하세요!!!
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            conn = getConnection();
            
            StringBuilder sql = new StringBuilder();
            sql.append("select * \n");
            sql.append("from board\n");
            sql.append("where article_no=?");
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setInt(1, no);
            
            rs = pstmt.executeQuery();
            if (rs.next()) {
                dto= new BoardDto();
                dto.setArticleNo(rs.getInt("article_no"));
                dto.setUserId(rs.getString("user_id"));
                dto.setSubject(rs.getString("subject"));
                dto.setContent(rs.getString("content"));
                dto.setRegisterTime(rs.getString("register_time"));
            }
            
        }catch(SQLException e) {
            
        }finally {
            // 6. 자원해제
        	DBUtil.getInstance().close(pstmt,conn,rs);
        }
//        END
        return dto;
	}

	@Override
	public void modifyArticle(BoardDto boardDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
//		TODO : boardDto의 내용을 이용하여 글번호에 해당하는 글제목과 내용을 수정하세요!!
		try {
			conn=getConnection();
			StringBuilder sql=new StringBuilder();
			sql.append("update board set subject=?, content=? where article_no=?");
			
			
			pstmt=conn.prepareStatement(sql.toString());
			pstmt.setString(1, boardDto.getSubject());
			pstmt.setString(2, boardDto.getContent());
			pstmt.setInt(3, boardDto.getArticleNo());
			
			
			int result=pstmt.executeUpdate();
			
			if(result==1) {
				System.out.println(boardDto.getArticleNo()+"번 수정 완료");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			// 6. 자원해제
//			try {
//				if(pstmt!=null) {
//					pstmt.close();
//				}
//				if(conn!=null) {
//					conn.close();
//				}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			DBUtil.getInstance().close(pstmt,conn);
		}
//		END
	}

	@Override
	public void deleteArticle(int no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
//		TODO : board table에서 글번호가 no인 글 정보를 삭제하세요!!!
		try {
			// 2. db 연결
			conn=getConnection(); 
			// 3. 통로 개설: 전용 통로
			StringBuilder sql=new StringBuilder();
			sql.append("delete from board where article_no=?");
			pstmt=conn.prepareStatement(sql.toString());
			pstmt.setInt(1, no);
			
			// 4. sql 수행요청
			// executeUpdate() : int - CUD
			// executeQuery() : ResultSet - R
			int result=pstmt.executeUpdate();
			
			// 5. 결과처리
			if(result==1) {
				System.out.println("성공-게시글 삭제 완료");
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 6. 자원해제
			DBUtil.getInstance().close(pstmt,conn);
			
		}
//		END
	}

}