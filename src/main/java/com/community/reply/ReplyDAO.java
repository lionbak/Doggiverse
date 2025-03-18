package com.community.reply;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import com.community.servlet.MyOracleConnection;

public class ReplyDAO {
	
	public ArrayList<ReplyVO> replyList(int bId){
		ArrayList<ReplyVO> list = new ArrayList<ReplyVO>();
		//변수들
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//DB
		MyOracleConnection obj = new MyOracleConnection();
		try {
			conn = obj.oracleConn();
			String sql = "select * from reply where boardid=? order by rseq desc";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bId);
			rs = ps.executeQuery();
			
			while(rs.next()){
				ReplyVO rvo = new ReplyVO();
				
				rvo.setRseq(rs.getInt("rseq"));
				rvo.setReply(rs.getString("reply"));
				rvo.setRegid(rs.getString("regid"));
				rvo.setRegdate(rs.getString("regdate"));
				list.add(rvo);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	finally {
			obj.oracleClose(conn,ps,rs);
		}
		return list; 
	}
	
	public int replyInsert(ReplyVO rvo) {
		Connection conn = null;
		PreparedStatement pstmt  = null;
		int insertRows = 0;
		MyOracleConnection moc = new MyOracleConnection();  //클래스 분리시켜놓아서 인스턴스 생성해서 사용
		String sql = null;
		
		try {
			
			conn = moc.oracleConn();
			sql = "insert into reply values(reply_seq.nextval,?,?,sysdate,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rvo.getReply());
			pstmt.setString(2, rvo.getRegid());
			pstmt.setInt(3, rvo.getBoardId());
			
			System.out.println("SQL: " + sql);
	        System.out.println("Reply: " + rvo.getReply());
	        System.out.println("Username: " + rvo.getRegid());
	        System.out.println("Board ID: " + rvo.getBoardId());
			insertRows =  pstmt.executeUpdate();
			System.out.println("Inserted Rows: " + insertRows);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			moc.oracleClose(conn, pstmt, null);
		}
		return insertRows;
	}
	
	public int replyDelete(int rseq) {
		Connection conn = null;
		PreparedStatement pstmt  = null;
		int delRows = 0;
		MyOracleConnection moc = new MyOracleConnection();  //클래스 분리시켜놓아서 인스턴스 생성해서 사용
		
		try {
			conn = moc.oracleConn();

			String sql = "delete from reply where rseq=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rseq);   							
			delRows =  pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			moc.oracleClose(conn, pstmt, null);
		}
		return delRows;
	}
}
