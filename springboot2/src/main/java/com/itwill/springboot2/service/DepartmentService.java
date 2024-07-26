package com.itwill.springboot2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.itwill.springboot2.domain.Department;
import com.itwill.springboot2.repository.DepartmentRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class DepartmentService {

	private final DepartmentRepository deptRepo;
	
	public List<Department> read() {
		log.info("read()");
		
		return deptRepo.findAll();
	}
	
    public Department getDepartmentDetails(Integer id) {
        log.info("getDepartmentDetails(id={})", id);
        
        return deptRepo.findById(id).orElse(null);
    }
    
}