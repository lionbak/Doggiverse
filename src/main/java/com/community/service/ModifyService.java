package com.community.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.community.board.BoardDAO;
import com.community.board.BoardVO;

public class ModifyService implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		//수정요청과 함께 넘어온 글번호 부터 받자
		int bId = Integer.parseInt(request.getParameter("bId"));
		
		
		//BoardVO를 받자
		BoardVO vo = BoardDAO.getInstance().contentBoard(bId); //주소값받고 컨텐츠보드의 글 번호를 받아야한다.
		
		
		//리퀘스트에 담아서 전달하자
		request.setAttribute("article", vo); //article이라는 이름으로 vo를 담아주자 > board_modify가서 name값으로 article써줄꺼임
		
		
		//보드 컨트롤러로가서 dp써주자
		
		
		
		
		
		
		
		
		
	}
}
