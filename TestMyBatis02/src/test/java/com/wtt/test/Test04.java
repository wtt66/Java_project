package com.wtt.test;

import com.wtt.mapper.BookMapper;
import com.wtt.pojo.Book;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Test04 {
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
        Book book = new Book();
        book.setId(6);
        book.setName("人与自然");
        book.setAuthor("王腾腾");
        book.setPrice(88);
        int i = mapper.updateBook(book, 5);
        if(i>0){
            System.out.println("书籍修改成功");
        }

        //事务操作
        sqlSession.commit();
        //关闭资源
        sqlSession.close();

    }
}
