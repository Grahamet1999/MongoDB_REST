package quintrix.api.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import quintrix.api.entity.User;
import quintrix.api.restService.UserService;

@RestController
public class UserController {

  private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);


  @Autowired
  UserService userService;

  @RequestMapping(method = RequestMethod.GET, value = "/users")
  List<User> getAllUsers() {
    logger.debug("Fetch all Users");
    return userService.fetchAllUser();
  }

  @RequestMapping(method = RequestMethod.GET, value = "/users/{id}")
  User getUserById(@PathVariable("id") int id) {
    logger.debug("Fetch User by Id");
    return userService.fetchUserById(id);
  }

  @RequestMapping(method = RequestMethod.POST, value = "/users")
  List<User> addUser(@RequestBody User user) {
    logger.debug("Save new User");
    return userService.saveUser(user);
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
  void deleteById(@PathVariable("id") int id) {
    logger.debug("Delete User");
    userService.deleteUserById(id);
  }

}
