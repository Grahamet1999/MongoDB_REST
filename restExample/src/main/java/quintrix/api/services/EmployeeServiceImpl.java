package quintrix.api.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quintrix.api.entity.Employee;
import quintrix.api.repositories.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  @Autowired
  EmployeeRepository employeeRepository;

  @Override
  public Employee saveEmployee(Employee employee) {
    // TODO Auto-generated method stub
    return employeeRepository.save(employee);
  }

  @Override
  public List<Employee> fetchAllEmployee() {
    // TODO Auto-generated method stub
    return employeeRepository.findAll();
  }

  @Override
  public Optional<Employee> fetchEmployeeById(long id) {
    // TODO Auto-generated method stub
    return employeeRepository.findById(id);
  }

  @Override
  public List<Employee> fetchEmployeeByFirstName(String first) {
    // TODO Auto-generated method stub
    List<Employee> employeeList = employeeRepository.findAll();
    return employeeList.stream().filter(c -> c.getFirstName().contains(first))
        .collect(Collectors.toList());
  }

  @Override
  public List<Employee> fetchEmployeeByLastName(String last) {
    // TODO Auto-generated method stub
    List<Employee> employeeList = employeeRepository.findAll();
    return employeeList.stream().filter(c -> c.getFirstName().contains(last))
        .collect(Collectors.toList());
  }

  @Override
  public List<Employee> fetchEmployeeByEmail(String email) {
    // TODO Auto-generated method stub
    List<Employee> employeeList = employeeRepository.findAll();
    return employeeList.stream().filter(c -> c.getFirstName().contains(email))
        .collect(Collectors.toList());
  }

  @Override
  public void deleteEmployee(long id) {
    // TODO Auto-generated method stub
    employeeRepository.deleteById(id);
  }

  @Override
  public Employee updateEmployee(Employee employee, long id) {
    // TODO Auto-generated method stub
    Employee getEmployee = employeeRepository.findById(id).get();

    if (Objects.nonNull(employee.getFirstName())) {
      getEmployee.setFirstName(employee.getFirstName());
    }
    if (Objects.nonNull(employee.getLastName())) {
      getEmployee.setLastName(employee.getLastName());
    }
    if (Objects.nonNull(employee.getEmail())) {
      getEmployee.setEmail(employee.getEmail());
    }


    return employeeRepository.save(getEmployee);
  }

}
