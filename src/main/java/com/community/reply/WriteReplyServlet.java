package com.community.reply;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.community.board.BoardDAO;
import com.community.board.BoardVO;

@WebServlet("/WriteReplyServlet")
public class WriteReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReplyDAO replyService;

    public void init() {
        replyService = new ReplyDAO();
    }   

    public WriteReplyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String replyText = request.getParameter("reply");
        int boardId = Integer.parseInt(request.getParameter("boardId"));
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        
        if (username != null && !replyText.isEmpty()) {
            ReplyVO rvo = new ReplyVO();
            rvo.setReply(replyText);
            rvo.setRegid(username);
            rvo.setBoardId(boardId);

            // 로그 추가
            System.out.println("Before calling replyInsert");
            
            int result = replyService.replyInsert(rvo);

            // 로그 추가
            System.out.println("After calling replyInsert, result: " + result);

            if (result > 0) {
                response.sendRedirect("/doggimain/content.board?bId=" + boardId);
            } else {
                request.setAttribute("errorMessage", "댓글 작성에 실패했습니다.");
                request.getRequestDispatcher("/doggimain/content.board?bId=" + boardId).forward(request, response);
            }
        } else {
            request.setAttribute("errorMessage", "댓글 내용을 입력해주세요.");
            request.getRequestDispatcher("/doggimain/content.board?bId=" + boardId).forward(request, response);
            
            
        }
    }
}
