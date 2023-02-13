package com.wtt.test01;

import java.sql.*;

public class Text {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/jiuye?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true";
        String username = "root";
        String password = "123456.";
        Connection conn = DriverManager.getConnection(url, username, password);
        //创建会话
        Statement sta = conn.createStatement();
        //发送SQL语句,rs为结果集
        ResultSet rs = sta.executeQuery("select *from t_book");
        //进行确认
        while (rs.next()){
            System.out.println(rs.getInt("id")+"---"+rs.getString("name")+"---"+rs.getString("author")+"---"+rs.getDouble("price"));

        }

        //关闭资源
        sta.close();
        conn.close();
    }
}
