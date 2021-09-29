package com.service.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.service.user.VO.Department;
import com.service.user.VO.ResponseEntityVO;
import com.service.user.entity.User;
import com.service.user.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	@Autowired
	RestTemplate restTemplate;
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	public ResponseEntityVO findUserById(Long id) {
		ResponseEntityVO responseEntityVO = new ResponseEntityVO();
		User user = userRepository.findByUserId(id);
		responseEntityVO.setUser(user);
		
		Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+ user.getDepartmentId(), Department.class);
		responseEntityVO.setDepartment(department);
		return responseEntityVO;
	}
	

}
