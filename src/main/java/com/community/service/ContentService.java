package com.community.service;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.community.board.BoardDAO;
import com.community.board.BoardVO;
import com.community.reply.ReplyDAO;
import com.community.reply.ReplyVO;

public class ContentService implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		
		
		//상세보기요청은 글번호가 몇번인지 알아야한다. board_list클래스에 .board?bId=${b.bardId} 라는 번호를 적었었으니 얻어오자
		
		int bId = Integer.parseInt(request.getParameter("bId"));
		
		//DAO의 주소값얻자
		BoardDAO dao = BoardDAO.getInstance(); //주소를받아야 객체부를수있으니. 싱글톤이니 new는 X
		

		String bNum = String.valueOf(bId);

		
		//요청과 함께 넘어온 쿠기가 있는지부터 확인해야겠지?
		boolean flag = false;
		Cookie[] cookies = request.getCookies();
		
		if(cookies != null) {
			for(Cookie c : cookies) {
				if(c.getName().equals(bNum)) {
					flag = true;
					break;
				}
			}
			if(!flag) {
				Cookie hitCoo = new Cookie(bNum, bNum);
				hitCoo.setMaxAge(15);
				
				response.addCookie(hitCoo);
				dao.upHit(bId);
			}
		}

		BoardVO vo = dao.contentBoard(bId);  //컨텐츠보드는 하나만 가져오기 때문에 BoardVO객체를 리턴한다. BoardVO vo로 받아주자.
		
		vo.setContent(vo.getContent().replace("\r\n", "<br>")); //vo에다가 Content내용을 다시 써줄꺼야. 기존의 vo가 갖고있는 content를 가지고 오되, 리플레이스해주자(교체) > 즉, textarea가 자동 줄개행이 되는 것을 표현할 것이다.
		
		
		ReplyDAO replyDao = new ReplyDAO();
        List<ReplyVO> replies = replyDao.replyList(bId);
        
		//클릭한 그 글을 몽땅 받아내자 (BoardDAO가서 contentBoard메서드를 먼저 완성하고 오자)
		request.setAttribute("content", vo); //content라는 이름으로 vo들을 다 담겠다.
		
		// 댓글 리스트도 request에 설정
        request.setAttribute("replies", replies);
        
		
	}
}
