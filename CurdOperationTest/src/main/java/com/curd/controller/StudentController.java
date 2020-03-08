package com.curd.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.curd.command.StudentCmd;
import com.curd.entity.StudentEntity;
import com.curd.service.StudentService;

@Controller
//@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	
	@GetMapping("/studentform")
	public String showForm(@ModelAttribute("studentcmd")StudentCmd cmd) {
		return "studentForm";
	}
	
	@PostMapping("/processform")
	public String processForm(@ModelAttribute("studentcmd")StudentCmd cmd,Model model) {
		StudentEntity entity=new StudentEntity();
		BeanUtils.copyProperties(cmd,entity);
		StudentEntity studentInfo = service.saveStudentInfo(entity);
		if(studentInfo!=null) {
		}
		return "studentForm";
	}
	
	@GetMapping("/delete")
	public String deleteRecord(@RequestParam("id")int id) {
		System.out.println("delte called");
		int deleteStudent = service.deleteStudent(id);
		return "redirect:report";
	}
	
	@GetMapping("/update")
	public String updateStudentById(@ModelAttribute("studentcmd")StudentCmd cmd,@RequestParam("id")int id,Model model) {
		StudentEntity studentEntity = service.findById(id);
		studentEntity.setId(id);
		BeanUtils.copyProperties(studentEntity, cmd);
		service.saveStudentInfo(studentEntity);
		return "studentForm";
	}
	
	@GetMapping("/report")
	public String getAllRecord(@ModelAttribute("studentcmd")StudentCmd cmd,Model model) {
		List<StudentEntity> allStudent = service.getAllStudent();
		model.addAttribute("studentlist",allStudent);
		return "studentReport";
	}
}
