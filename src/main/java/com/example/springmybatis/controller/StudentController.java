package com.example.springmybatis.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springmybatis.domain.Students;
import com.example.springmybatis.service.StudentService;

@RestController
public class StudentController {

	private final StudentService studentService;

	public StudentController(StudentService studentService) {    // 생성자 주입
		this.studentService = studentService;
	}

	@GetMapping("/students/count")
	public int countStudents() {
		int countStudent = studentService.countStudent();
		System.out.println("countStudent = " + countStudent);
		return countStudent;
	}

	// students DB 전체 정보 출력
	@GetMapping("/students")
	public List<Students> getAllStudents(@RequestParam(required = false) Long id) {
		return studentService.getStudents(id);
	}

	@PostMapping("/students")	// POST /students { "name": "이름", "age": 20, "address": "서울시"}
	public String addStudent(@RequestBody Students students) {
		// INSERT
		studentService.saveStudent(students);
		return "OK";
	}
}
