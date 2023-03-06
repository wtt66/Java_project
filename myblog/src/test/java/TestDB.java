import java.sql.Timestamp;
import java.util.List;

public class TestDB {
    // 1. 验证插入
    public static void testInsert() {
        Blog blog = new Blog();
        blog.setTitle("我的第一篇博客");
        blog.setContent("这是博客的正文");
        blog.setUserId(1);
// 基于当前的时间戳, 创建 java.sql.Date 对象
        blog.setPostTime(new Timestamp(System.currentTimeMillis()));
        BlogDao blogDao = new BlogDao();
        blogDao.insert(blog);
    }
    public static void testSelectAll() {
        BlogDao blogDao = new BlogDao();
        List<Blog> blogs = blogDao.selectAll();
        System.out.println(blogs);
    }
    public static void testSelectOne() {
        BlogDao blogDao = new BlogDao();
        Blog blog = blogDao.selectOne(1);
        System.out.println(blog);
    }
    public static void testDelete() {
        BlogDao blogDao = new BlogDao();
        blogDao.delete(1);
    }
    public static void testUserInsert() {
        User user = new User();
        user.setUsername("测试用户");
        user.setPassword("123");
        UserDao userDao = new UserDao();
        userDao.insert(user);
    }
    public static void testUserSelectByName() {
        UserDao userDao = new UserDao();
        User user = userDao.selectByName("测试用户");
        System.out.println(user);
    }
    public static void testUserSelectById() {
        UserDao userDao = new UserDao();
        User user = userDao.selectById(1);
        System.out.println(user);
    }
    public static void main(String[] args) {
// ......
        testInsert();
    }
}
