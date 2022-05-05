package quintrix.api.restService;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import quintrix.api.entity.User;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  RestTemplate restTemplate;

  private String uri = "https://gorest.co.in/public/v2/users";


  @Override
  public List<User> saveUser(User user) {
    List<User> userList = fetchAllUser();
    userList.add(0, user);
    return userList;
  }

  @Override
  public List<User> fetchAllUser() {
    List<User> user = null;
    ResponseEntity<List<User>> response = restTemplate.exchange(uri, HttpMethod.GET, null,
        new ParameterizedTypeReference<List<User>>() {});

    if (response.getStatusCode() == HttpStatus.OK) {
      user = response.getBody();
    }
    return user;
  }

  @Override
  public User fetchUserById(int id) {
    List<User> userList = fetchAllUser();

    Optional<User> user = userList.stream().filter(u -> u.getId().equals(id)).findAny();
    return user.get();
  }

  @Override
  public void deleteUserById(int id) {

    List<User> userList = fetchAllUser();
    userList.removeIf(u -> u.getId().equals(id));
  }

}
