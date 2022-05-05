package quintrix.api.services;

import java.util.List;
import java.util.Optional;
import quintrix.api.entity.Employee;

public interface EmployeeService {

  Employee saveEmployee(Employee employee);

  List<Employee> fetchAllEmployee();

  Optional<Employee> fetchEmployeeById(long id);

  List<Employee> fetchEmployeeByFirstName(String first);

  List<Employee> fetchEmployeeByLastName(String last);

  List<Employee> fetchEmployeeByEmail(String email);

  void deleteEmployee(long id);

  Employee updateEmployee(Employee employee, long id);

}
