package be.pxl.services.controller;

import be.pxl.services.domain.Employee;
import be.pxl.services.services.IEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final IEmployeeService employeeService;

    @GetMapping
    public ResponseEntity getEmployees(){
        return new ResponseEntity(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getEmployeeById(@PathVariable Long id){
        return new ResponseEntity(employeeService.getEmployeeById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity addEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/department/{departmentId}")
    public ResponseEntity getEmployeesByDepartment(@PathVariable Long departmentId){
        return new ResponseEntity(employeeService.getEmployeesByDepartment(departmentId), HttpStatus.OK);
    }
    @GetMapping("/organization/{organizationId}")
    public ResponseEntity getEmployeesByOrganization(@PathVariable Long organizationId){
        return new ResponseEntity(employeeService.getEmployeesByOrganization(organizationId), HttpStatus.OK);
    }
}