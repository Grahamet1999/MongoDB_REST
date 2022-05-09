package quintrix.MongoDB.services;

import java.util.List;
import java.util.Optional;
import quintrix.MongoDB.mongoDocuments.Posts;

public interface PostService {

  List<Posts> getAllPosts();

  Posts addPost(Posts post);

  Optional<Posts> getPostById(String id);

  List<Posts> getPostByUserId(Long id);

  void deletePosts(String id);

}
