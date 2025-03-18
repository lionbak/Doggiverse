package com.community.board;

import java.util.List;

import com.community.common.PageVO;

public interface IBoardDAO {

	
	//글 등록 메서드(모든 게시판 등록은 이 regist로 사용하게끔 박아놈)
	void regist(String writer, String title, String content); 
	//이렇게 박아놓으면 나중에 게시판 종류가 늘어나던, 모든 게시판은 이 인터페이스를 구현하겠다 라고 얘기하면 등록메서드는 regist로 쓸 수 있다. 자유게시판도 공지사항도 건의사항게시판들도 regist로 가동될 것이다.
	//regist() 괄호 안에 돌리고자 하는 SQL을 생각해보자.
	//보내야하는 메서드는 writer, title, content만 전달하고자 한다면? String writer, String title, String content를 써주면 된다. 이러면 3가지로 SQL완성하면 된다.
	
	
	
	


	//페이징 처리 이후 지정된 범위의 글 목록을 가져오는 메서드
	List<BoardVO>listBoard(PageVO paging);
	
	
	
	//글 상세보기(글 하나 보기) 요청을 처리할 메서드
	BoardVO contentBoard(int bId);


	
	
	
	//글 수정 요청을 처리할 메서드. (작성자는 수정안하고 제목만 내용만 수정할 것이다)
	void updateBoard(String title, String content, int bId); //제목과 내용만 수정할꺼니까 제목, 내용, 글번호 이다. 이걸 넘겨주겠지~

	
	
	
	
	//글 삭제 요청
	void deleteBoard(int bId); //where = 글번호? 니까 글번호가 매개값으로 오겠다.
	
	
	
	
	
	//글 검색 요청을 처리할 메서드 (추상메서드 추가)
	List<BoardVO>searchBoard(String keyword, String category); 
	
	
	
	
	
	//조회수를 올려주는 메서드
	void upHit(int bId); //매개값으로는 글번호를 알려주자
	
	
	
	
	
	
	
	//총 게시물 수를 알려주는 (추상)메서드
	int countArticles(); //매개값이뭔지 리턴은뭘로할지 SQL을 생각해보자
	// SELECT COUNT(*) FROM my_board;
	// 매개변수는 필요없다. 물음표 채우는게 없으니. 그럼 매개값은 없다.
	// 리턴은 int로 받자. count가 인트니까
	
	
}
