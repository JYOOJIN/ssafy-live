package com.ssafy.board.controller;

import java.io.IOException;
import java.util.List;

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.service.BoardService;
import com.ssafy.board.model.service.BoardServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/article")
public class BoardController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private BoardService boardService;
    private String root;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        boardService = BoardServiceImpl.getBoardService();
        // 서블릿에서 초기화 수행시에 현재 서블릿이 속한 application(ServletContext) 객체를 이용해서
        // 서블릿컨텍스트 패스 초기화 설정 수행
        root = getServletContext().getContextPath();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        String path = "";
        if ("list".equals(action)) {
            path = list(request, response);
            forward(request, response, path);
        } else if ("view".equals(action)) {
            path = view(request, response);
            forward(request, response, path);
        } else if ("mvwrite".equals(action)) {
            path = "/board/write.jsp";
            redirect(request, response, path);
        } else if ("write".equals(action)) {
            path = write(request, response);
            redirect(request, response, path);
        } else if ("mvmodify".equals(action)) {
            path = mvModify(request, response);
            forward(request, response, path);
        } else if ("modify".equals(action)) {
            path = modify(request, response);
            forward(request, response, path);
        } else if ("delete".equals(action)) {
            path = delete(request, response);
            redirect(request, response, path);
        } else {
            redirect(request, response, path);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        doGet(request, response);
    }

    private void forward(HttpServletRequest request, HttpServletResponse response, String path)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(path);
        dispatcher.forward(request, response);
    }

    private void redirect(HttpServletRequest request, HttpServletResponse response, String path) throws IOException {
        response.sendRedirect(request.getContextPath() + path);
    }

    private String list(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<BoardDto> list = boardService.listArticle();
            System.out.println("debug: list: " + list);
            request.setAttribute("articles", list);
            return "/board/list.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            return "/index.jsp";
        }
    }

    private String view(HttpServletRequest request, HttpServletResponse response) {
        int articleNo = Integer.parseInt(request.getParameter("articleno"));
        try {
            BoardDto boardDto = boardService.getArticle(articleNo);
            boardService.updateHit(articleNo);
            request.setAttribute("article", boardDto);
            return "/board/view.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            return "/index.jsp";
        }
    }

    private String write(HttpServletRequest request, HttpServletResponse response) {
        BoardDto boardDto = new BoardDto();
        boardDto.setUserId(request.getParameter("userid"));
        boardDto.setSubject(request.getParameter("subject"));
        boardDto.setContent(request.getParameter("content"));
        try {
            boardService.writeArticle(boardDto);
            return "/article?action=list";
        } catch (Exception e) {
            e.printStackTrace();
            return "/index.jsp";
        }
    }


	private String mvModify(HttpServletRequest request, HttpServletResponse response) {
		// TODO : 수정하고자하는 글의 글번호를 얻는다.
		int articleNo=Integer.parseInt(request.getParameter("articleno"));
		System.out.println("debug articleNO:"+articleNo);
		// TODO : 글번호에 해당하는 글정보를 얻고 글정보를 가지고 modify.jsp로 이동.
		try {
			BoardDto boardDto=boardService.getArticle(articleNo);
			request.setAttribute("article", boardDto);
			
			//RequestDispatcher path=request.getRequestDispatcher("/board/modify.jsp");
			//path.forward(request, response);
			
			return "/board/modify.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			return "/index.jsp";
		}

	}

	private String modify(HttpServletRequest request, HttpServletResponse response) {
		// TODO : 수정 할 글정보를 얻고 BoardDto에 set: articleno, subject, content
		int articleNo=Integer.parseInt(request.getParameter("articleno"));
		String subject=request.getParameter("subject");
		String content=request.getParameter("content");
		
		// TODO : boardDto를 파라미터로 service의 modifyArticle() 호출.
		BoardDto boardDto=new BoardDto();
		boardDto.setArticleNo(articleNo);
		boardDto.setSubject(subject);
		boardDto.setContent(content);
		System.out.println("debug dto:"+boardDto);
		
		try {
			boardService.modifyArticle(boardDto);
			// TODO : 글수정 완료 후 view.jsp로 이동.(이후의 프로세스를 생각해 보세요.)
			// view.jsp는 상세조회 요청에 대한 응답페이지 이므로 view.jsp로 바로 이동할 수는 없다
			// 따라서 articleNo에 대한 상세 요청을 통해서 해당 요청이 응답할 수 있도록 처리해야한다
			// 2가지 방법 다 가능하다.
			return view(request,response);
			//return "article?action=view&articleno="+articleNo;
			
		} catch (Exception e) {
			e.printStackTrace();
			return "/index.jsp";
		}
	}

	private String delete(HttpServletRequest request, HttpServletResponse response) {
		// TODO : 삭제할 글 번호를 얻는다.
		int articleNo=Integer.parseInt(request.getParameter("articleno"));
		System.out.println("delete article no: " + articleNo);
		// TODO : 글번호를 파라미터로 service의 deleteArticle()을 호출.
		try {
			boardService.deleteArticle(articleNo);
			// TODO : 글삭제 완료 후 list.jsp로 이동.(이후의 프로세스를 생각해 보세요.)
			// 글삭제후에 응답은 글목록 조회
			// list.jsp는 글목록 조회에 대한 응답페이지이므로
			// 응답 요청을 통해서 응답받아야하는 응답화면
			// return list(request,response);
			
			return "/article?action=list";
		} catch (Exception e) {
			e.printStackTrace();
			return "/index.jsp";
		}
	}

}