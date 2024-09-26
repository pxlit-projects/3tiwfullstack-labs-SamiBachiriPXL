package be.pxl.services.services;

import be.pxl.services.domain.Employee;
import be.pxl.services.domain.dto.EmployeeRequest;
import be.pxl.services.domain.dto.EmployeeResponse;

import java.util.List;

public interface IEmployeeService {

    List<EmployeeResponse> getAllEmployees();

    Employee getEmployeeById(Long id);
    void addEmployee(EmployeeRequest employee);
    List<EmployeeResponse> getEmployeesByDepartment(Long departmentId);
    List<EmployeeResponse> getEmployeesByOrganization(Long organizationId);
}
