package quintrix.MongoDB.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import quintrix.MongoDB.mongoDocuments.Posts;
import quintrix.MongoDB.services.PostService;

@RestController
public class PostsController {

  @Autowired
  PostService postService;

  @RequestMapping(method = RequestMethod.GET, value = "/posts")
  List<Posts> getAllPosts() {
    return postService.getAllPosts();
  }

  @RequestMapping(method = RequestMethod.GET, value = "/posts/{id}")
  Optional<Posts> getPostById(@PathVariable("id") String id) {
    return postService.getPostById(id);
  }

  @RequestMapping(method = RequestMethod.GET, value = "/posts")
  List<Posts> getPostByUserId(@RequestParam(name = "user_Id", required = false) long id) {
    return postService.getPostByUserId(id);
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/posts/{id}")
  void deletePostByID(@PathVariable("id") String id) {
    postService.deletePosts(id);
  }

  @RequestMapping(method = RequestMethod.POST, value = "/posts")
  Posts addPost(@RequestBody Posts post) {
    return postService.addPost(post);
  }
}
