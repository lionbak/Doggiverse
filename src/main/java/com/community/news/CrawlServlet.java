package com.community.news;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


@WebServlet("/CrawlServlet")
public class CrawlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CrawlServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
//		 NaverNewsCrawl crawler = new NaverNewsCrawl();
//	        ArrayList<NewsVO> newsList = crawler.getNaverNews();
//
//	        // 크롤링한 뉴스 데이터를 request 객체에 추가
//	        request.setAttribute("newsList", newsList);
//	 
//	        // JSP 페이지로 포워딩
//	        request.getRequestDispatcher("/News.jsp").forward(request, response);
		NaverNewsCrawl nnc = new NaverNewsCrawl();
		ArrayList<NewsVO> list = nnc.getNaverNews();
		
		Gson gson = new Gson();
		String jsonRes = gson.toJson(list);
		PrintWriter out = response.getWriter(); //화면에 print
		out.print(jsonRes);
		out.flush();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
