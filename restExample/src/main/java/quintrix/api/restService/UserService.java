package quintrix.api.restService;

import org.springframework.web.client.RestTemplate;
import quintrix.api.entity.User;

public interface UserService {

  Object saveUser(User user, RestTemplate restTemplate);

  Object fetchAllUser(RestTemplate restTemplate);

  User fetchUserById(int id, RestTemplate restTemplate);

  void deleteUserById(int id, RestTemplate restTemplate);

}
