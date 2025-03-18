package com.community.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.community.reply.ReplyVO;
import com.community.servlet.MyOracleConnection;

public class CallTest {
	
	public BoardVO contentBoard(int bId) {
		MyOracleConnection moc = new MyOracleConnection(); 
        BoardVO board = null;
        List<ReplyVO> replies = new ArrayList<>();
        String sql = "SELECT b.board_id, b.title, b.content, b.writer, b.reg_date, b.hit, "
                   + "r.rseq, r.reply, r.regid as rregid, r.regdate as rregdate "
                   + "FROM my_board b LEFT JOIN reply r ON b.board_id = r.seq "
                   + "WHERE b.board_id = ? "
                   + "ORDER BY r.rseq DESC";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = moc.oracleConn();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, bId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                if (board == null) {
                    board = new BoardVO(
                        rs.getInt("board_id"),
                        rs.getString("writer"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getTimestamp("reg_date").toLocalDateTime(),
                        rs.getInt("hit"),
                        new ArrayList<>() // 댓글 리스트 초기화
                    );
                }
                int rseq = rs.getInt("rseq");
                if (rseq != 0) { // 댓글이 있을 경우
                    ReplyVO reply = new ReplyVO();
                        rs.getInt("board_id");
                        rs.getString("rregid");
                        rs.getString("reply");
                        rs.getTimestamp("rregdate").toLocalDateTime();
                    replies.add(reply);
                }
            }
            if (board != null) {
                board.setReplies(replies);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            moc.oracleClose(conn, pstmt, rs);
        }
        return board;
    }
	public static void main(String[] args) {
		CallTest ct = new CallTest();
		System.out.println(ct.contentBoard(1));

	}

}
