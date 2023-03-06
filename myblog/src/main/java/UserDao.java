//import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    // 新增用户信息, 用于注册
    public void insert(User user) {
        Connection connection = DBUtil.getConnection();
        String sql = "insert into user values(null, ?, ?)";
        PreparedStatement statement = null;
        try {
            statement = (PreparedStatement) connection.prepareStatement(sql);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, null);
        }

    }

    // 根据用户名查询 User 对象
    public User selectByName(String username) {
        Connection connection = DBUtil.getConnection();
        String sql = "select * from user where username = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = (PreparedStatement) connection.prepareStatement(sql);
            statement.setString(1, username);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getInt("userId"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, resultSet);
        }
        return null;
    }


    // 根据用户 id 查询 User 对象
    public User selectById(int userId) {
        Connection connection = DBUtil.getConnection();
        String sql = "select * from user where userId = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = (PreparedStatement) connection.prepareStatement(sql);
            statement.setInt(1, userId);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getInt("userId"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, resultSet);
        }
        return null;

    }

}
