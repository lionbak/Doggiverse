package com.community.reply;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.community.board.BoardDAO;
import com.community.board.BoardVO;

@WebServlet("/DelReplyServlet")
public class DelReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DelReplyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String rseqParam = request.getParameter("rseq");
		String bIdParam = request.getParameter("bId");
	    if (rseqParam == null || rseqParam.isEmpty() || bIdParam == null || bIdParam.isEmpty()) {
	        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "rseq 파라미터가 누락되었습니다.");
	        return;
	    }

	    try {
	        int rseq = Integer.parseInt(rseqParam);
	        ReplyDAO replyDAO = new ReplyDAO();
	        int result = replyDAO.replyDelete(rseq);
	        int bId = Integer.parseInt(bIdParam);
	        if (result > 0) {
	            // 댓글 삭제 성공 시 리다이렉트 또는 성공 메시지 전송
	        	 response.sendRedirect("/doggimain/content.board?bId=" + bId); // 원하는 페이지로 리다이렉트
	        } else {
	            // 댓글 삭제 실패 시 오류 처리
	            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "댓글 삭제에 실패했습니다.");
	        }
	    } catch (NumberFormatException e) {
	        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "유효하지 않은 rseq 파라미터: " + rseqParam + "," + bIdParam);
	    }
	}


//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
