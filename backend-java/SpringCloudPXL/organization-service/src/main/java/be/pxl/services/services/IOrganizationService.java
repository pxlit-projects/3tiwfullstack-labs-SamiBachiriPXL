package be.pxl.services.services;

import be.pxl.services.domain.Organization;

import java.util.List;

public interface IOrganizationService {
    Organization getOrganizationById(Long id);
    Organization findByIdWithDepartments(Long id);

    Organization findByIdWithDepartmentsAndEmployees(Long id);

    Organization findByIdWithEmployees(Long id);
}
