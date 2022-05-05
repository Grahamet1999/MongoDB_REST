package quintrix.api.entity;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee {
  private @Id @GeneratedValue long id;
  private String firstName;
  private String lastName;
  private String email;

  Employee() {}

  public Employee(String firstName, String lastName, String email) {
    super();
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public boolean equals(Object o) {

    if (this == o)
      return true;
    if (!(o instanceof Employee))
      return false;
    Employee employee = (Employee) o;
    return Objects.equals(this.id, employee.id) && Objects.equals(this.firstName, employee.lastName)
        && Objects.equals(this.lastName, employee.lastName)
        && Objects.equals(this.email, employee.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.firstName, this.lastName, this.email);
  }

  @Override
  public String toString() {
    return "Employee{" + "id=" + this.id + ", first name='" + this.firstName + '\''
        + ", last name='" + this.lastName + '\'' + ", email='" + this.email + '\'' + '}';
  }

}
