import org.testng.Assert;
import org.testng.annotations.Test;

public class EmployeeTest {

    @Test
    public void employeeNameTest() {
        Employee employee = new Employee();
        employee.setName("Renars");
        Assert.assertEquals(employee.getName(), "Renars");
    }

    @Test
    public void employeeSurnameTest() {
        Employee employee = new Employee();
        employee.setSurname("Malnacs");
        Assert.assertEquals(employee.getSurname(), "Malnacs");
    }

    @Test
    public void employeeYearTest() {
        Employee employee = new Employee();
        employee.setYear(2018);
        Assert.assertEquals(employee.getYear(), 2018);
    }

    @Test
    public void employeeRoleTest() {
        Employee employee = new Employee();
        employee.setRole("Developer");
        Assert.assertEquals(employee.getRole(), "Developer");
    }

    @Test
    public void employeeConstructorTest() {
        Employee employee = new Employee("John", "Doe", 1994, "Janitor");
        Assert.assertEquals(employee.getName(), "John");
        Assert.assertEquals(employee.getSurname(), "Doe");
        Assert.assertEquals(employee.getYear(), 1994);
        Assert.assertEquals(employee.getRole(), "Janitor");
    }

}
