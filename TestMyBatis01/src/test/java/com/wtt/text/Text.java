package com.wtt.text;

import com.wtt.pojo.Book;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Text {
    public static void main(String[] args) throws IOException {
        //指定核心配置文件路径
        String resource = "mybatis.xml";
        //获取加载配置文件的输入流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //加载配置文件，创建工厂类
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //通过工厂类获取一个会话：
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行查询
        List list = sqlSession.selectList("a.b.selectAllBooks");
        //遍历
        for (int i = 0; i < list.size(); i++) {
            Book b = (Book)list.get(i);
            System.out.println(b.getId()+"---"+b.getName()+"---"+b.getAuthor()+"---"+b.getPrice());


        }
        //关闭资源
        sqlSession.close();

    }
}
