package com.community.board;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import com.community.reply.ReplyVO;

public class BoardVO {

//	CREATE TABLE my_board (
//		    board_id NUMBER PRIMARY KEY,
//		    writer VARCHAR2(30) NOT NULL,
//		    title VARCHAR2(100) NOT NULL,
//		    content VARCHAR2(2000),
//		    reg_date DATE DEFAULT sysdate,
//		    hit NUMBER DEFAULT 0
//		);
	
	private int boardId;
	private String writer;
	private String title;
	private String content;
	private LocalDateTime regDate;
	private int hit;
	
	List<ReplyVO> replies;
	public BoardVO() {
	}


	public BoardVO(int boardId, String writer, String title, String content, LocalDateTime regDate, int hit) {
		super();
		this.boardId = boardId;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.hit = hit;
	}

	public BoardVO(int boardId, String writer, String title, String content, LocalDateTime regDate, int hit, List<ReplyVO> replies) {
		//super();
		this(boardId, writer, content, title, regDate, hit);
		this.replies = replies;
	}
	public int getBoardId() {
		return boardId;
	}


	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}


	public String getWriter() {
		return writer;
	}


	public void setWriter(String writer) {
		this.writer = writer;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public LocalDateTime getRegDate() {
		return regDate;
	}


	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}


	public int getHit() {
		return hit;
	}


	public void setHit(int hit) {
		this.hit = hit;
	}

	
	public List<ReplyVO> getReplies() {
		return replies;
	}


	public void setReplies(List<ReplyVO> replies) {
		this.replies = replies;
	}


	@Override
	public String toString() {
		return "BoardVO [boardId=" + boardId + ", writer=" + writer + ", title=" + title + ", content=" + content
				+ ", regDate=" + regDate + ", hit=" + hit + ", replies=" + replies + "]";
	}


	

	
}
