package be.pxl.services.services;

import be.pxl.services.domain.Department;
import be.pxl.services.domain.Organization;
import be.pxl.services.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrganizationService implements IOrganizationService{
    private final OrganizationRepository organizationRepository;
    private final DepartmentService departmentService;
    @Override
    public Organization getOrganizationById(Long id) {
        return organizationRepository.findById(id).orElse(null);
    }

    @Override
    public Organization findByIdWithDepartments(Long id) {
        return organizationRepository.findById(id).map(organization -> {
            organization.setDepartments(departmentService.getDepartmentsByOrganization(organization.getId()));
            return organization;
        }).orElse(null);
    }

    @Override
    public Organization findByIdWithDepartmentsAndEmployees(Long id) {
        return organizationRepository.findById(id).map(organization -> {
            organization.setDepartments(departmentService.getDepartmentsByOrganizationWithEmployees(organization.getId()));
            return organization;
        }).orElse(null);
    }

    @Override
    public Organization findByIdWithEmployees(Long id) {
        return organizationRepository.findById(id).map(organization -> {
            organization.setEmployees(departmentService.getDepartmentsByOrganizationWithEmployees(organization.getId())
                    .stream()
                    .flatMap(department -> department.getEmployees().stream())
                    .toList());
            return organization;
        }).orElse(null);
    }
}