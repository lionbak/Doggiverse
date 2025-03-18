package com.community.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.community.board.BoardDAO;
import com.community.board.BoardVO;

public class DeleteService implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

			BoardDAO
				.getInstance()
				.deleteBoard(Integer.parseInt(request.getParameter("bId")));
		}
	}
