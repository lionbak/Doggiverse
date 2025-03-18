package com.community.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.community.common.PageVO;
import com.community.reply.ReplyVO;
import com.community.users.UserVO;
import com.community.servlet.MyOracleConnection;

public class BoardDAO implements IBoardDAO {

    private MyOracleConnection moc;

    private BoardDAO() {
        moc = new MyOracleConnection();
    }

    private static BoardDAO dao = new BoardDAO();

    public static BoardDAO getInstance() {
        if (dao == null) {
            dao = new BoardDAO();
        }
        return dao;
    }

    @Override
    public void regist(String writer, String title, String content) {
        String sql = "INSERT INTO my_board (board_id, writer, title, content) VALUES(board_seq.NEXTVAL, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = moc.oracleConn();
            //DB연결 성공 유무
            if (conn != null) {
                System.out.println("DB 연결 성공");
            } else {
                System.out.println("DB 연결 실패");
                return;
            }
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, writer);
            pstmt.setString(2, title);
            pstmt.setString(3, content);
            pstmt.executeUpdate();
            //글 등록이 성공했는지 유 무 확인
//            int result = pstmt.executeUpdate();
//            if (result > 0) {
//                System.out.println("데이터 삽입 성공");
//            } else {
//                System.out.println("데이터 삽입 실패");
//            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            moc.oracleClose(conn, pstmt, null);
        }
    }

    @Override
    public List<BoardVO> listBoard(PageVO paging) {
        List<BoardVO> articles = new ArrayList<>();
        String sql = "SELECT * FROM ( SELECT ROWNUM AS rn, tbl.* FROM ( SELECT * FROM my_board ORDER BY board_id DESC ) tbl ) WHERE rn > ? AND rn <= ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = moc.oracleConn();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, (paging.getPage() - 1) * paging.getCpp());
            pstmt.setInt(2, paging.getPage() * paging.getCpp());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                BoardVO vo = new BoardVO(
                    rs.getInt("board_id"),
                    rs.getString("writer"),
                    rs.getString("title"),
                    rs.getString("content"),
                    rs.getTimestamp("reg_date").toLocalDateTime(),
                    rs.getInt("hit")
                );
                articles.add(vo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            moc.oracleClose(conn, pstmt, rs);
        }
        return articles;
    }

    @Override
    public BoardVO contentBoard(int bId) {
        BoardVO vo = null;
        String sql = "SELECT * FROM my_board WHERE board_id=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = moc.oracleConn();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, bId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                vo = new BoardVO(
                    rs.getInt("board_id"),
                    rs.getString("writer"),
                    rs.getString("title"),
                    rs.getString("content"),
                    rs.getTimestamp("reg_date").toLocalDateTime(),
                    rs.getInt("hit")
                    
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            moc.oracleClose(conn, pstmt, rs);
        }
        return vo;
    }
    
    
    @Override
    public void updateBoard(String title, String content, int bId) {
        String sql = "UPDATE my_board SET title=?, content=? WHERE board_id=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = moc.oracleConn();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, title);
            pstmt.setString(2, content);
            pstmt.setInt(3, bId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            moc.oracleClose(conn, pstmt, null);
        }
    }

    @Override
    public void deleteBoard(int bId) {
        String sql = "DELETE FROM my_board WHERE board_id=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = moc.oracleConn();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, bId);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            moc.oracleClose(conn, pstmt, null);
        }
    }

    @Override
    public List<BoardVO> searchBoard(String keyword, String category) {
        List<BoardVO> searchList = new ArrayList<>();
        String sql = "SELECT * FROM my_board WHERE " + category + " LIKE ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = moc.oracleConn();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + keyword + "%");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                BoardVO vo = new BoardVO(
                    rs.getInt("board_id"),
                    rs.getString("writer"),
                    rs.getString("title"),
                    rs.getString("content"),
                    rs.getTimestamp("reg_date").toLocalDateTime(),
                    rs.getInt("hit")
                );
                searchList.add(vo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            moc.oracleClose(conn, pstmt, rs);
        }
        return searchList;
    }

    @Override
    public void upHit(int bId) {
        String sql = "UPDATE my_board SET hit=hit+1 WHERE board_id=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = moc.oracleConn();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, bId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            moc.oracleClose(conn, pstmt, null);
        }
    }

    @Override
    public int countArticles() {
        int count = 0;
        String sql = "SELECT COUNT(*) FROM my_board";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = moc.oracleConn();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            moc.oracleClose(conn, pstmt, rs);
        }
        return count;
    }
    
    
    public static void main (String[] args) {
    	BoardDAO dao = new BoardDAO();
    	dao.contentBoard(1);
    	System.out.println("컨텐츠"+dao.contentBoard(1));
    	BoardDAO boardDAO = new BoardDAO();
        PageVO paging = new PageVO(); // page 1, 10 items per page
        List<BoardVO> boardList = boardDAO.listBoard(paging);

        for (BoardVO board : boardList) {
            System.out.println("리스트"+board);
        }
    	
    }
}
	

