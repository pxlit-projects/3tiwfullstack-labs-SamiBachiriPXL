package be.pxl.services.services;

import be.pxl.services.domain.Employee;

import java.util.List;

public interface IEmployeeService {

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long id);
    void addEmployee(Employee employee);
    List<Employee> getEmployeesByDepartment(Long departmentId);
    List<Employee> getEmployeesByOrganization(Long organizationId);
}
