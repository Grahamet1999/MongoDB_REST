package quintrix.api.controller;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import quintrix.api.entity.Employee;
import quintrix.api.services.EmployeeService;

@RestController
public class EmployeeController {

  private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

  @Autowired
  EmployeeService employeeService;

  @RequestMapping(method = RequestMethod.GET, value = "/employees")
  List<Employee> fetchAllEmployee() {
    logger.debug("Fetch all Employees");
    return employeeService.fetchAllEmployee();
  }

  @RequestMapping(method = RequestMethod.GET, value = "/employees/{id}")
  Optional<Employee> fetchEmployeeByID(@PathVariable("id") long id) {
    logger.debug("Fetch Employee by id");
    return employeeService.fetchEmployeeById(id);
  }

  @RequestMapping(method = RequestMethod.POST, value = "/employees")
  Employee saveEmployee(@Validated @RequestBody Employee employee) {
    logger.debug("Save new Employee");
    return employeeService.saveEmployee(employee);
  }

  @RequestMapping(method = RequestMethod.PUT, value = "/employees/{id}")
  Employee updateEmployee(@Validated @RequestBody Employee employee, @PathVariable("id") long id) {
    logger.debug("Update Employee");
    return employeeService.updateEmployee(employee, id);
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/employees/{id}")
  String deleteById(@PathVariable("id") long id) {
    employeeService.deleteEmployee(id);
    logger.debug("Delete Employee");
    return "Deleted Successfully";
  }

  @RequestMapping(method = RequestMethod.GET, value = "/employeeSearchBy")
  List<Employee> getByFirstName(@RequestParam(name = "first", required = false) String first,
      @RequestParam(name = "last", required = false) String last,
      @RequestParam(name = "email", required = false) String email) {

    if (first != null) {
      return employeeService.fetchEmployeeByFirstName(first);
    } else if (last != null) {
      return employeeService.fetchEmployeeByLastName(last);
    } else if (email != null) {
      return employeeService.fetchEmployeeByEmail(email);
    } else {
      return null;
    }
  }

}
