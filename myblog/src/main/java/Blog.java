import java.sql.Timestamp;

public class Blog {
    private int blogId;
    private String title;
    private String content;
    private int userId;
    // 注意, 此处不能使用 java.sql.Date(这个类只有年月日, 没有时分秒)
// 而应该使用 java.sql.TimeStamp
    private Timestamp postTime;

    public Blog(int blogId, String title, String content, int userId, Timestamp postTime) {
        this.blogId = blogId;
        this.title = title;
        this.content = content;
        this.userId = userId;
        this.postTime = postTime;
    }

    public Blog() {
    }

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Timestamp getPostTime() {
        return postTime;
    }

    public void setPostTime(Timestamp postTime) {
        this.postTime = postTime;
    }
}
