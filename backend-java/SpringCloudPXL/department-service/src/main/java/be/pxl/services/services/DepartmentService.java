package be.pxl.services.services;

import be.pxl.services.domain.Department;
import be.pxl.services.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService implements IDepartmentService{
    private final DepartmentRepository departmentRepository;
    private final EmployeeService employeeService;

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    @Override
    public void addDepartment(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public List<Department> getDepartmentsByOrganization(Long organizationId) {
        return departmentRepository.findByOrganizationId(organizationId);
    }

    @Override
    public List<Department> getDepartmentsByOrganizationWithEmployees(Long organizationId) {
        return departmentRepository.findByOrganizationId(organizationId)
                .stream()
                .map(department -> {
                    department.setEmployees(employeeService.getEmployeesByDepartment(department.getId()).stream().map(employee -> employeeService.mapToEmployee(employee)).toList());
                    return department;
                }).toList();
    }
}