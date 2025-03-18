package com.community.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.community.board.BoardDAO;
import com.community.board.BoardVO;

public class SearchService implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		String category = request.getParameter("category");
		String keyword = request.getParameter("search");
		
		List<BoardVO> list = BoardDAO.getInstance().searchBoard(keyword, category);
		
		if(list.size() == 0) {
			response.setContentType("text/html; charset=UTF-8");
			
			try {
				PrintWriter out = response.getWriter();
				String htmlCode =  "<script>\r\n"
	                    + "alert('검색 결과에 따른 게시물이 없습니다.');\r\n"
						+ "location.href='/doggimain/list.board?page=1&cpp=';\r\n"
	                    + "</script>";
				out.print(htmlCode);
				out.flush();
				return;

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		request.setAttribute("boardList", list);
	}
}
