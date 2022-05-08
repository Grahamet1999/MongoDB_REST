package quintrix.MongoDB.services;

import java.util.List;
import quintrix.MongoDB.mongoDocuments.Posts;

public interface PostService {

  List<Posts> getAllPosts();

  Posts addPost(Posts post);

  Posts getPostById(long id);

  List<Posts> getPostByUserId(long id);

  void deletePosts(long id);
}
