

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BlogDao {
    // 把一个博客对象插入到 blog 表中
    public void insert(Blog blog) {
        Connection connection = DBUtil.getConnection();
        String sql = "insert into blog values(null, ?, ?, ?, ?)";
        PreparedStatement statement = null;
        try {
            statement  = (PreparedStatement)connection.prepareStatement(sql);
            statement.setString(1, blog.getTitle());
            statement.setString(2, blog.getContent());
            statement.setInt(3, blog.getUserId());
            statement.setTimestamp(4, blog.getPostTime());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, null);
        }
    }

    // 从 blog 表中查找到所有的 blog 对象
    public List<Blog> selectAll() {
        List<Blog> blogs = new ArrayList<>();
        Connection connection = DBUtil.getConnection();
        String sql = "select * from blog";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = (PreparedStatement) connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Blog blog = new Blog();
                blog.setBlogId(resultSet.getInt("blogId"));
                blog.setTitle(resultSet.getString("title"));
                blog.setContent(resultSet.getString("content"));
                blog.setUserId(resultSet.getInt("userId"));
                blog.setPostTime(resultSet.getTimestamp("postTime"));
                blogs.add(blog);
            }
            return blogs;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, resultSet);
        }
        return null;
    }

    // 从 blog 表中查找到指定的 blog 对象
    public Blog selectOne(int blogId) {
        Connection connection = DBUtil.getConnection();
        String sql = "select * from blog where blogId = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = (PreparedStatement) connection.prepareStatement(sql);
            statement.setInt(1, blogId);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Blog blog = new Blog();
                blog.setBlogId(resultSet.getInt("blogId"));
                blog.setTitle(resultSet.getString("title"));
                blog.setContent(resultSet.getString("content"));
                blog.setUserId(resultSet.getInt("userId"));
                blog.setPostTime(resultSet.getTimestamp("postTime"));
                return blog;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, resultSet);
        }
        return null;
    }
    // 删除指定的 blog 对象
    public void delete(int blogId) {
        Connection connection = DBUtil.getConnection();
        String sql = "delete from blog where blogId = ?";
        PreparedStatement statement = null;
        try {
            statement = (PreparedStatement) connection.prepareStatement(sql);
            statement.setInt(1, blogId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, null);
        }

    }



}
