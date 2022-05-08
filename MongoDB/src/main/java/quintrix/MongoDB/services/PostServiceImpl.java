package quintrix.MongoDB.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.client.RestTemplate;
import quintrix.MongoDB.mongoDocuments.Posts;
import quintrix.MongoDB.repository.PostsRepository;

public class PostServiceImpl implements PostService {

  @Autowired
  PostsRepository postRepository;

  @Autowired
  RestTemplate restTemplate;

  @Autowired
  MongoTemplate mongoTemplate;

  @Override
  public List<Posts> getAllPosts() {
    List<Posts> postList = postRepository.findAll();
    return postList;
  }

  @Override
  public Posts addPost(Posts post) {
    Posts posts = new Posts(post.getUser_id(), post.getTitle(), post.getBody());

    return postRepository.insert(posts);
  }

  @Override
  public Optional<Posts> getPostById(String id) {
    return postRepository.findById(id);
  }

  @Override
  public List<Posts> getPostByUserId(long id) {

    Query query = new Query();
    query.addCriteria(Criteria.where("user_id").is(id));
    return mongoTemplate.find(query, Posts.class);
  }

  @Override
  public void deletePosts(String id) {
    postRepository.deleteById(id);
  }

}
