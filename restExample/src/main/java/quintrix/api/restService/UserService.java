package quintrix.api.restService;

import java.util.List;
import quintrix.api.entity.User;

public interface UserService {

  List<User> saveUser(User user);

  List<User> fetchAllUser();

  User fetchUserById(int id);

  void deleteUserById(int id);

}
