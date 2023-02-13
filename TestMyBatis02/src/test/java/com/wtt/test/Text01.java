package com.wtt.test;

import com.wtt.mapper.BookMapper;
import com.wtt.pojo.Book;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Text01 {
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
        //动态代理模式
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        //Book b = mapper.selectOneBook("线性代数", "王腾腾");
        Book book = new Book();
        book.setName("线性代数");
        book.setAuthor("王腾腾");
        Book b = mapper.selectOneBook2(book);
        //遍历
        System.out.println(b.getId()+"---"+b.getName()+"---"+b.getAuthor()+"---"+b.getPrice());
        //关闭资源
        sqlSession.close();
    }
}
