package be.pxl.services.controller;

import be.pxl.services.services.IOrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/organization")
@RequiredArgsConstructor
public class OrganizationController {
    private final IOrganizationService organizationService;

    @GetMapping("/{id}")
    public ResponseEntity getOrganizationById(@PathVariable Long id){
        return new ResponseEntity(organizationService.getOrganizationById(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/with-departments")
    public ResponseEntity getOrganizationByIdWithDepartments(@PathVariable Long id){
        return new ResponseEntity(organizationService.findByIdWithDepartments(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/with-departments-and-employees")
    public ResponseEntity getOrganizationByIdWithDepartmentsAndEmployees(@PathVariable Long id){
        return new ResponseEntity(organizationService.findByIdWithDepartmentsAndEmployees(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/with-employees")
    public ResponseEntity getOrganizationByIdWithEmployees(@PathVariable Long id){
        return new ResponseEntity(organizationService.findByIdWithEmployees(id), HttpStatus.OK);
    }
}
