package com.itwill.springboot2.repository;

// import static 구문: static 메서드, 필드 이름을 임포트.
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.springboot2.domain.Employee;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class EmployeeRepositoryTest {
    
    @Autowired // 의존성 주입(DI: dependency injection), 제어의 역전(IoC: Inversion of Control)
    private EmployeeRepository empRepo;

//    @Test
    public void test() {
        //Assertions.assertNotNull(empRepo);
        assertThat(empRepo).isNotNull(); // empRepo 객체가 null이 아니면 테스트 성공.
        log.info("empRepo: {}", empRepo);
    }
    
    // select * from emp
//    @Test
    public void findAllTest() {
        List<Employee> list = empRepo.findAll();
        assertThat(list.size()).isEqualTo(14);
        
        for (Employee e : list) {
            System.out.println(e);
        }
    }
    
    @Transactional
    @Test
    public void findByTest() {
        // 사번이 테이블에 있는 경우:
        Optional<Employee> emp1 = empRepo.findById(7788);
//        Employee scott = emp1.get();
        Employee scott = emp1.orElseGet(() -> null);
        assertThat(scott).isNotNull();
        assertThat(scott.getEname()).isEqualTo("SCOTT");
        log.info("scott={}", scott);
        log.info("dept={}", scott.getDepartment());
        
        // 사번이 테이블에 없는 경우:
        Optional<Employee> emp2 = empRepo.findById(1000);
        Employee none = emp2.orElseGet(() -> null);
        assertThat(none).isNull();
    }
    
    @Transactional
    @Test
    public void findManagerTest() {
    	// 사번이 7369인 직원 정보 검색:
    	Employee emp = empRepo.findById(7369).orElseThrow();
    	assertThat(emp.getId()).isEqualTo(7369);
    	log.info("emp={}", emp);
    	
    	Employee mgr = emp.getManager();
    	assertThat(mgr.getId()).isEqualTo(7369); // 7963 직원의 매니저는 7902
    	log.info("emp={}", emp);
    	
    	
    }
    
}