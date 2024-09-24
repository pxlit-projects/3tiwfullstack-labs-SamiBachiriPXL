package be.pxl.services.services;

import be.pxl.services.domain.Department;
import be.pxl.services.domain.Employee;

import java.util.List;

public interface IDepartmentService {
    List<Department> getAllDepartments();
    Department getDepartmentById(Long id);
    void addDepartment(Department department);

    List<Department> getDepartmentsByOrganization(Long organizationId);

    List<Department> getDepartmentsByOrganizationWithEmployees(Long organizationId);
}
