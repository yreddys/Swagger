package net.yarraneella.departmentservice.service.impl;

import java.util.List;


import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.yarraneella.departmentservice.dto.DepartmentDto;
import net.yarraneella.departmentservice.entity.Department;
import net.yarraneella.departmentservice.exception.DepartmentNotFoundException;
import net.yarraneella.departmentservice.repository.DepartmentRepository;
import net.yarraneella.departmentservice.service.DepartmentService;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentRepository departmentRepository;

	@Override
	public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

		// convert department dto to department jpa entity
		Department department = new Department(departmentDto.getId(), departmentDto.getDepartmentName(),
				departmentDto.getDepartmentDescription(), departmentDto.getDepartmentCode());

		Department savedDepartment = departmentRepository.save(department);

		DepartmentDto savedDepartmentDto = new DepartmentDto(savedDepartment.getId(),
				savedDepartment.getDepartmentName(), savedDepartment.getDepartmentDescription(),
				savedDepartment.getDepartmentCode());

		return savedDepartmentDto;
	}

	@Override
	public DepartmentDto getDepartmentByCode(String departmentCode) throws DepartmentNotFoundException {

		Department department = departmentRepository.findByDepartmentCode(departmentCode);

		if (department == null) {
			throw new DepartmentNotFoundException("Department with code " + departmentCode + " not found");
		}

		DepartmentDto departmentDto = new DepartmentDto(department.getId(), department.getDepartmentName(),
				department.getDepartmentDescription(), department.getDepartmentCode());

		return departmentDto;
	}

	@Override
	public List<Department> getAllData() {
		
		return departmentRepository.findAll();
	}

	
	 
}
