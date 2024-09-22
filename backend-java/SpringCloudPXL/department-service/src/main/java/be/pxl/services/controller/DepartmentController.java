package be.pxl.services.controller;

import be.pxl.services.domain.Department;
import be.pxl.services.services.IDepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/department")
@RequiredArgsConstructor
public class DepartmentController {
    private final IDepartmentService departmentService;

    @GetMapping
    public ResponseEntity getDepartments(){
        return new ResponseEntity(departmentService.getAllDepartments(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getDepartmentById(@PathVariable Long id){
        return new ResponseEntity(departmentService.getDepartmentById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity addDepartment(@RequestBody Department department){
        departmentService.addDepartment(department);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/{organizationId}")
    public ResponseEntity getDepartmentsByOrganization(@PathVariable Long organizationId){
        return new ResponseEntity(departmentService.getDepartmentsByOrganization(organizationId), HttpStatus.OK);
    }
}
