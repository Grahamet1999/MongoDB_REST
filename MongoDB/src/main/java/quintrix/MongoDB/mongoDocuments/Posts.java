package quintrix.MongoDB.mongoDocuments;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "posts")
public class Posts {

  @Id
  private long id;

  private long user_id;

  private String title;

  private String body;

  public Posts(long user_id, String title, String body) {
    super();
    this.user_id = user_id;
    this.title = title;
    this.body = body;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getUser_id() {
    return user_id;
  }

  public void setUser_id(long user_id) {
    this.user_id = user_id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  @Override
  public String toString() {
    return "Posts [id=" + id + ", user_id=" + user_id + ", title=" + title + ", body=" + body + "]";
  }

}
