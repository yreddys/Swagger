package net.yarraneella.departmentservice.service;

import java.util.List;

import net.yarraneella.departmentservice.dto.DepartmentDto;
import net.yarraneella.departmentservice.entity.Department;
import net.yarraneella.departmentservice.exception.DepartmentNotFoundException;

public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartmentByCode(String code) throws DepartmentNotFoundException;

	List<Department> getAllData();

	
}
