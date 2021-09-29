package com.service.department.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.department.entity.Department;
import com.service.department.repository.DepartmentRepository;

@Service
public class DepartmentService {
	@Autowired
	DepartmentRepository departmentRepository;

	public Department saveDepartment(final Department department) {
		return departmentRepository.save(department);
	}

	public Department findDepartmentById(Long id) {
		// TODO Auto-generated method stub
		return departmentRepository.findByDepartmentId(id);
	}

}
