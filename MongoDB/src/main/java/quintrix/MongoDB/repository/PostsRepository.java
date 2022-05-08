package quintrix.MongoDB.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import quintrix.MongoDB.mongoDocuments.Posts;


public interface PostsRepository extends MongoRepository<Posts, String> {

}
