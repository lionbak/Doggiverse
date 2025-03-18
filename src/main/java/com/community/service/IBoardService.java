package com.community.service;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IBoardService { //인터페이스로 만듦

	void execute(HttpServletRequest request, HttpServletResponse response); //얘는 매개값으로 컨트롤러로부터 리케스트와 리스폰스를 받아 처리해줄 것이다
	//즉, 추상메서드 선언해준 것이다.
}
