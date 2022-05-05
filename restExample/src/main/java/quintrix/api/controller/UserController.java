package quintrix.api.controller;

import java.util.List;
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

  @Autowired
  UserService userService;

  @RequestMapping(method = RequestMethod.GET, value = "/users")
  List<User> getAllUsers() {
    return userService.fetchAllUser();
  }

  @RequestMapping(method = RequestMethod.GET, value = "/users/{id}")
  User getUserById(@PathVariable("id") int id) {
    return userService.fetchUserById(id);
  }

  @RequestMapping(method = RequestMethod.POST, value = "/users")
  List<User> addUser(@RequestBody User user) {
    return userService.saveUser(user);
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
  void deleteById(@PathVariable("id") int id) {
    userService.deleteUserById(id);
  }

}
