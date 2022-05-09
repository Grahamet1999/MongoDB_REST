package quintrix.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import quintrix.api.entity.User;
import quintrix.api.restService.UserService;

@RestController
public class UserController {

  private static final Logger logger = LoggerFactory.getLogger(User.class);


  @Autowired
  UserService userService;

  @RequestMapping(method = RequestMethod.GET, value = "/users")
  Object getAllUsers(RestTemplate restTemplate) {
    logger.debug("Fetch all Users");
    return userService.fetchAllUser(restTemplate);
  }

  @RequestMapping(method = RequestMethod.GET, value = "/users/{id}")
  User getUserById(@PathVariable("id") int id, RestTemplate restTemplate) {
    logger.debug("Fetch User by Id");
    return userService.fetchUserById(id, restTemplate);
  }

  @RequestMapping(method = RequestMethod.POST, value = "/users")
  Object addUser(@RequestBody User user, RestTemplate restTemplate) {
    logger.debug("Save new User");
    return userService.saveUser(user, restTemplate);
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
  void deleteById(@PathVariable("id") int id, RestTemplate restTemplate) {
    logger.debug("Delete User");
    userService.deleteUserById(id, restTemplate);
  }

}
