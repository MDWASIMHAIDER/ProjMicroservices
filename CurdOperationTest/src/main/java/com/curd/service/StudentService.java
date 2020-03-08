package com.curd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curd.entity.StudentEntity;
import com.curd.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repo;
	
	public StudentEntity saveStudentInfo(StudentEntity st) {
		StudentEntity studentEntity = repo.save(st);
		return studentEntity;
	}
	
	public List<StudentEntity> getAllStudent(){
		List<StudentEntity> list = repo.findAll();
		return list;
	}
	
	public int deleteStudent(int id) {
		int deleteStudentById = repo.deleteStudentById(id);
		return deleteStudentById;
	}
	
	public StudentEntity findById(int id) {
		Optional<StudentEntity> findById = repo.findById(id);
		StudentEntity studentEntity = findById.get();
		return studentEntity;
	}
	/*public StudentEntity updateStudentById(int id) {
		repo.save(entity)
	}*/
}
