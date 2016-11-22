package com.example;

import java.util.ArrayList;
import java.util.HashSet;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.model.Dept;
import com.example.model.Emp;
import com.example.repository.DeptRepository;

@SpringBootApplication
public class ManyToOneApplication implements CommandLineRunner {
	
	private static final Logger logger = LoggerFactory.getLogger(ManyToOneApplication.class);
	
	@Autowired
	private DeptRepository deptRepository;
	
	@Override
	@Transactional
	public void run(String... arg0) throws Exception {
		testLog();
		testInsert();
		testFindAll();
//		testDelete();
//		testFindAll();
	}

	private void testDelete() {
		deptRepository.delete(1L);
	}

	private void testFindAll() {
		for (Dept dept : deptRepository.findAll()) {
			logger.info(dept.toString());
		}
	}

	private void testInsert() {
		Dept d1 = new Dept("develop");
		Emp e1 = new Emp("kim");
		Emp e2 = new Emp("cha");
		
		// 순서 보장 x
		d1.setEmps(new HashSet<Emp>(){
			{
				add(e1);
				add(e2);
			}
		});
		
		// 순서 보장 x
		Dept d2 = new Dept("manage", new HashSet<Emp>(){
			{
				add(new Emp("lee"));
				add(new Emp("park"));
			}
		});
		
		// 
		deptRepository.save(new ArrayList<Dept>(){
			{
				add(d1);
				add(d2);
			}
		});
	}

	private void testLog() {
		logger.warn("ManyToOneApplication: 1");
		System.out.println("ManyToOneApplication: 1");
	}

}
