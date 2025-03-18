package com.community.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.community.board.BoardDAO;
import com.community.board.BoardVO;
import com.community.service.ContentService;
import com.community.service.DeleteService;
import com.community.service.GetListService;
import com.community.service.IBoardService;
import com.community.service.ModifyService;
import com.community.service.RegistService;
import com.community.service.SearchService;
import com.community.service.UpdateService;

@WebServlet("*.board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	private IBoardService sv;
	private RequestDispatcher dp;


    public BoardController() {
        super();
    }



	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	if(request.getMethod().equals("POST")) {
		request.setCharacterEncoding("utf-8");
	}

	String uri = request.getRequestURI();
	uri = uri.substring(request.getContextPath().length()+1, uri.lastIndexOf("."));

	System.out.println(uri);

		switch(uri) {

	case "write":
		System.out.println("글쓰기 페이지로 이동 요청!");
		response.sendRedirect("/doggimain/board_nwrite.jsp");
		break;

	case "regist":
		System.out.println("글 등록 요청이 들어옴!");
		sv = new RegistService();
		sv.execute(request, response);

		//글 등록이 완료됐으니 list로 가야겠지
		response.sendRedirect("/doggimain/list.board?page=1&cpp=");
		                                             //   board/board_list.jsp라고 적으면 안된다.
													 //   jsp파일은 형태만있을뿐, 데이터 내용으로 뿌려주는 것이 아니다.
		  											 //   글 등록 완료되었으니 글 목록을 보여달라고 다시 요청해야한다.
													 //   그래야 글 목록을 싹다 뜯어올 수 있다.
													 //	  즉, board_list.jsp에는 DB로부터 전체 글 목록을 가져오는 로직을 작성하지 않을 것이다. (jsp는 단순히 보여지는 역할만 수행하기 때문이다)
												     //	  그래서 컨트롤러로 글 목록 요청이 다시 들어올 수 있게끔, sendRedirect()를 사용하여 자동 목록 재 요청이 들어오게 해야 한다.
		break;

	case "list":
		System.out.println("글 목록 요청이 들어옴!");
		sv = new GetListService();
		sv.execute(request, response);

		dp = request.getRequestDispatcher("/board_list.jsp"); //경로설정완료
		//dp = request.getRequestDispatcher("board/board_list.jsp"); //경로설정완료
		//이제 dp한테 명령내리자
		dp.forward(request, response); //그럼 디스패쳐가 리퀘스트내장객체와 리스폰스내장객체를 가지고 응답안나가고 우리가 지정한 path로 간다. 그쪽으로 전달된다.
		break; //꺼내는건 EL을 쓰자.  board_list.jsp의 tbody로가서 뿌려주자


	case "content":
		System.out.println("글 상세보기 요청이 들어옴!");
		sv = new ContentService();
		sv.execute(request, response);
		//list에도 dp를 사용하고 content에서도 dp를 사용하니, 전체적으로 이클래스안에서만 하기 위해 private RequestDispatcher dp; 를 선언해서 쓰자 맨 위로가서 선언하자
		dp = request.getRequestDispatcher("board_detail.jsp"); //여기로가.
		dp.forward(request, response);
		break;



	case "modify":
		System.out.println("글 수정 페이지로 이동!");
		sv = new ModifyService();
		sv.execute(request, response);
		dp = request.getRequestDispatcher("/board_modi.jsp");
		dp.forward(request,  response);
		break;



	case "update":
		System.out.println("글 수정 요청이 들어옴!");
		sv = new UpdateService();
		sv.execute(request, response);
		response.sendRedirect("/doggimain/content.board?bId=" + request.getParameter("bId"));
		break;


	case "delete":
		System.out.println("글 삭제 요청이 들어옴!");
		sv = new DeleteService();
		sv.execute(request, response);
		response.sendRedirect("/doggimain/list.board");
		break;


	case "search":
		System.out.println("글 검색 요청이 들어옴!");
		sv = new SearchService();
		sv.execute(request, response);
		if(request.getAttribute("boardList") != null) {
			dp = request.getRequestDispatcher("/board_list.jsp");
			dp.forward(request, response);
		}
		break;

	}
  }
}
