package quintrix.MongoDB;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import quintrix.MongoDB.controller.PostsController;

@SpringBootTest
@TestPropertySource(properties = "spring.mongodb.embedded.version=3.5.5")
class MongoDbApplicationTests {

  @Autowired
  private PostsController postController;

  @Test
  void contextLoads() throws Exception {
    assertThat(postController).isNotNull();
  }

}
