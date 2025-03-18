package com.community.users;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;
import com.community.servlet.MyOracleConnection;
import com.community.util.DBUtil;
import com.community.model.User;


public class UserDAO {

    private static final String INSERT_USER_SQL = "INSERT INTO users (username, password, email, nickname, dog_name, address, phone_number, birthday,address2) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public boolean registerUser(User user) {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getNickname());
            preparedStatement.setString(5, user.getDogName());
            preparedStatement.setString(6, user.getAddress());
            preparedStatement.setString(7, user.getPhoneNumber());
            preparedStatement.setDate(8, new Date(user.getBirthday().getTime()));
            preparedStatement.setString(9, user.getAddress2());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isUsernameExist(String username) {
        String query = "SELECT COUNT(*) FROM users WHERE username = ?";
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean isNicknameExist(String nickname) {
        String query = "SELECT COUNT(*) FROM users WHERE nickname = ?";
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, nickname);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public UserVO userLogin(String username, String password) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        UserVO uvo = null;

        try {
            // Assuming MyOracleConnection provides a valid connection method
            MyOracleConnection moc = new MyOracleConnection();
            conn = moc.oracleConn();
            String sql = "SELECT username, password, email, nickname, dog_name, address, phone_number, address2 FROM users WHERE username=? AND password=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();

            if (rs.next()) {
                uvo = new UserVO();
                uvo.setUsername(rs.getString("username"));
                uvo.setPassword(rs.getString("password"));
                uvo.setEmail(rs.getString("email"));
                uvo.setNickname(rs.getString("nickname"));
                uvo.setDog_name(rs.getString("dog_name"));
                uvo.setAddress(rs.getString("address"));
                uvo.setAddress2(rs.getString("address2"));
                uvo.setPhoneNumber(rs.getString("phone_number"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return uvo;
    }

    public boolean updateUserInfo(String username, String nickname, String dogName, String address, String address2, String phoneNumber) {
        Connection conn = null;
        PreparedStatement ps = null;
        int result = 0;

        try {
            conn = DBUtil.getConnection();
            String sql = "UPDATE users SET nickname = ?, dog_name = ?, address = ?, address2 = ?, phone_number = ? WHERE username = ?";
            ps = conn.prepareStatement(sql);

            ps.setString(1, nickname);
            ps.setString(2, dogName);
            ps.setString(3, address);
            ps.setString(4, address2);
            ps.setString(5, phoneNumber);
            ps.setString(6, username);

            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result > 0;
    }

    public boolean deleteUser(String username) {
        Connection conn = null;
        PreparedStatement ps = null;
        int result = 0;

        try {
            conn = DBUtil.getConnection();
            String sql = "DELETE FROM users WHERE username = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result > 0;
    }

    public boolean updateUserPassword(String username, String newPassword) {
        String query = "UPDATE users SET password = ? WHERE username = ?";
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, newPassword);
            preparedStatement.setString(2, username);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean verifyPassword(String username, String currentPassword) {
        String query = "SELECT COUNT(*) FROM users WHERE username = ? AND password = ?";
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, currentPassword);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
		UserDAO dao = new UserDAO();
        // 유효한 username과 password를 입력해야 함
        UserVO uvo = dao.userLogin("a123", "a123123");

        if (uvo != null) {
            System.out.println(uvo.toString());
        } else {
            System.out.println("Login failed");
        }
}
		
	}