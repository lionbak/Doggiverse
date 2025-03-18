package com.community.reply;

import java.util.ArrayList;

public class ReplyCallTest {
	
	public static void main(String[] args) {
		ReplyDAO dao = new ReplyDAO();
		ArrayList<ReplyVO> rlist =  dao.replyList(1);
		
		for(ReplyVO rvo  : rlist) {
			int rseq = rvo.getRseq(); 
			String reply = rvo.getReply();
			System.out.println("\t" +rseq + "\t" + reply);
		}
	}
}
