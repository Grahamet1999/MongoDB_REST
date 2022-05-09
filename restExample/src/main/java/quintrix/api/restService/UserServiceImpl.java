package quintrix.api.restService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
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

  @Value("${userService.getUrl}")
  String userServiceGetUrl;

  @Value("${userService.getToken}")
  String userServiceGetToken;

  @Override
  public Object saveUser(User user, RestTemplate restTemplate) {

    HttpHeaders header = new HttpHeaders();
    HttpEntity<User> request = new HttpEntity<User>(user, header);
    header.set("Authorization", userServiceGetToken);

    return restTemplate.exchange(userServiceGetUrl, HttpMethod.POST, request, User.class).getBody();
  }

  @Override
  public Object fetchAllUser(RestTemplate restTemplate) {

    ArrayList<User> allUsers = new ArrayList<User>();

    ResponseEntity<User[]> response = restTemplate.getForEntity(userServiceGetUrl, User[].class);

    allUsers.addAll(Arrays.asList(Objects.requireNonNull(response.getBody())));

    return new ResponseEntity<>(allUsers, HttpStatus.OK);
  }

  @Override
  public User fetchUserById(int id, RestTemplate restTemplate) {

    String url = userServiceGetUrl + id;
    url += "?access-token=" + userServiceGetToken;
    return restTemplate.getForObject(url, User.class);

  }

  @Override
  public void deleteUserById(int id, RestTemplate restTemplate) {

    HttpHeaders header = new HttpHeaders();
    HttpEntity<User> request = new HttpEntity<User>(header);
    header.set("Authorization", userServiceGetToken);
    String url = userServiceGetUrl + id;
    restTemplate.exchange(url, HttpMethod.DELETE, request, String.class).getBody();

  }

}
