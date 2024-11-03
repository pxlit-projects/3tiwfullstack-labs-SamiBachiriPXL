package be.pxl.services.services;

import be.pxl.services.client.NotificationClient;
import be.pxl.services.domain.Employee;
import be.pxl.services.domain.NotificationRequest;
import be.pxl.services.domain.dto.EmployeeRequest;
import be.pxl.services.domain.dto.EmployeeResponse;
import be.pxl.services.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService implements IEmployeeService{

    private final EmployeeRepository employeeRepository;
    private final NotificationClient notificationClient;

    @Override
    public List<EmployeeResponse> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(employee -> mapToEmployeeResponse(employee)).toList();
    }

    private EmployeeResponse mapToEmployeeResponse(Employee employee) {
        return EmployeeResponse.builder()
                .name(employee.getName())
                .age(employee.getAge())
                .position(employee.getPosition())
                .build();
    }

    public Employee mapToEmployee(EmployeeResponse employee) {
        return Employee.builder()
                .name(employee.getName())
                .age(employee.getAge())
                .position(employee.getPosition())
                .build();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void addEmployee(EmployeeRequest employee) {
        Employee newEmployee = Employee.builder()
                        .age(employee.getAge())
                        .name(employee.getName())
                        .position(employee.getPosition()).build();

        employeeRepository.save(newEmployee);
        NotificationRequest notificationRequest = NotificationRequest.builder()
                .message("Employee created")
                .sender("Tom")
                .build();
        notificationClient.sendNotification(notificationRequest);
    }

    @Override
    public List<EmployeeResponse> getEmployeesByDepartment(Long departmentId) {
        List<Employee> employees = employeeRepository.findByDepartmentId(departmentId);
        return employees.stream().map(employee -> mapToEmployeeResponse(employee)).toList();
    }

    @Override
    public List<EmployeeResponse> getEmployeesByOrganization(Long organizationId) {
        List<Employee> employees = employeeRepository.findByDepartmentId(organizationId);
        return employees.stream().map(employee -> mapToEmployeeResponse(employee)).toList();
    }


}
