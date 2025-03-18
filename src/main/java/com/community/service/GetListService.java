package com.community.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.community.common.PageCreator;
import com.community.common.PageVO;
import com.community.board.BoardDAO;
import com.community.board.BoardVO;

public class GetListService implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		PageVO paging = new PageVO(); //객체생성
		BoardDAO dao = BoardDAO.getInstance();
		// 페이지 및 cpp 파라미터 값이 빈 문자열인지 확인하고 처리합니다.
        String pageParam = request.getParameter("page");
        String cppParam = request.getParameter("cpp");
        int page = 1; // 기본 페이지 값 설정
        int cpp = 10; // 기본 cpp 값 설정

        if (pageParam != null && !pageParam.isEmpty()) {
            page = Integer.parseInt(pageParam);
        }
        if (cppParam != null && !cppParam.isEmpty()) {
            cpp = Integer.parseInt(cppParam);
        }

        // 페이지와 cpp 값을 설정합니다.
        paging.setPage(page);
        paging.setCpp(cpp);

        // DB로부터 글 목록을 가져옵니다.
        List<BoardVO> boardList = dao.listBoard(paging);

        // 디버그 출력
        System.out.println("Board List: " + boardList);
        
        // 페이지 버튼 배치를 위한 객체를 생성합니다.
        PageCreator pc = new PageCreator();
        pc.setPaging(paging); // PageVO 객체인 paging을 전달
        pc.setArticleTotalCount(dao.countArticles()); // 알고리즘도 같이 돌자

        // request에 글 목록과 페이지 정보를 설정합니다.
        request.setAttribute("boardList", boardList);
        request.setAttribute("pc", pc);
//		if(request.getParameter("page") != null) {
//			paging.setPage(Integer.parseInt(request.getParameter("page"))); 
//			paging.setCpp(Integer.parseInt(request.getParameter("cpp")));
//		}
//		
//		System.out.println(paging);
//		
//		//DB한테 말해서 전부 다 가져오면 되겠다.
//		//입력을 통해 로직을 쓰는게 아니니 겟파라미터할거는 없다.
//		//바로부르자
//		//BoardDAO dao = BoardDAO.getInstance();  > 주소값 가져왔는데, 페이징 처리할때부터 사용하려고 위에다쓰고 이건 주석처리.
//
//		List<BoardVO> boardList = dao.listBoard(paging); //글 목록을 boardList로 받자. (BoardDAO의 public List<BoardVO> listBoard() { 메서드 내용을 받은 것이다)
//													
//		
//		
//												   	     //!!!!!!!!!!그러나 페이징한 후, 그에 맞는 정보만 가져오기 위해 ()에 paging쓰자. 페이징 전에는 아무것도 안적었다.
//														 //!!!!!!!!!!그리고 BoardDAO가서 listboard를 오버라이딩 한 곳에 매개값 적어주자~~~~~~
//												         //그리고 IBoardDAO가서도 메서드 적기
//		
//		//페이지 버튼 배치를 위해 객체를 생성
//		PageCreator pc = new PageCreator();
//		pc.setPaging(paging); //PageVO객체인 paging을 전달.
//		pc.setArticleTotalCount(dao.countArticles()); //알고리즘도 같이 돌자~
//		
//		
//		
//		
//		request.setAttribute("boardList", boardList);  
//		//즉, 왜 session을 사용하지 않고 request를 사용하는가?
//		//DB로부터 받아온 글 목록은 일시적인 데이터이다.
//		//글 목록은 언제든 변할 수 있기 때문에 이러한 데이터를 굳이 session에 담아서 유지할 필요가 있을까?
//		//화면으로 응답이 나가고나서 자동으로 소멸할 수 있도록 request에 담아서 화면으로 전달하고자 한다.
//		
//		
//		
//		
//		request.setAttribute("pc", pc);
		
	}
}
