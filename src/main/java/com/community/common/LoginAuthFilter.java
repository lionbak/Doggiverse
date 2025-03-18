package com.community.common;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter(

		filterName = "loginAuth",

		urlPatterns = {"/write.board", "/modify.board", "/delete.board", "/myPage.user", "/modPage.user"},
		servletNames = {"basic"}
		)
public class LoginAuthFilter extends HttpFilter implements Filter {
       
    public LoginAuthFilter() {
        super();
    }

    
    
    
    
	public void destroy() { //사실없어도됨
	}

	
	
	
	
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	

			System.out.println("doFilter 메서드가 발동!");

			HttpSession session = ((HttpServletRequest) request).getSession(); 

			if(session.getAttribute("username") == null) {

				System.out.println("회원 권한 없음! 통과 안됨!");
				HttpServletResponse resp = (HttpServletResponse) response;
			
				resp.setContentType("text/html; charset=UTF-8");
				PrintWriter out = resp.getWriter();
				out.print("<script> \r\n");
				out.print("alert('로그인이 필요한 페이지 입니다.'); \r\n");
				out.print("location.href='/doggimain/login.jsp'; \r\n");
				out.print("</script> \r\n");
				

				out.flush();
				out.close();
				return;
			}
		
		chain.doFilter(request, response);
	}

	
	
	
	
	public void init(FilterConfig fConfig) throws ServletException { //사실없어도그만인 메서드
		//웹 컨테이너(서버)가 시작될 때 필터 객체를 생성하는데,
		//이 때, 객체가 생성되면서 최초 한 번 호출이 되는 메서드이다.(생성자랑비슷)
		//필터에서 처리 시 필요한 객체 등을 초기화(JDBC 관련 설정) 하는데 사용한다.
		//우리는 JDBC를 굳이 필터에서 사용할 필요 X. 이미 커넥션 풀로 초기화를 해놓은 상태이다.
		System.out.println("로그인 권한 필터 객체가 생성!");
		
	}
}
