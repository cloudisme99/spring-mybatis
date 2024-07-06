package com.example.springmybatis.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springmybatis.domain.Students;
import com.example.springmybatis.repository.StudentRepository;

@Service
public class StudentService {

	private final StudentRepository studentRepository;

	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	// service는 비즈니스 로직을 구현할 필요없이 원하는 값 Return만 하면된다
	public int countStudent() {
		return studentRepository.countStudents();
	}

	public List<Students> getStudents(Long id) {
		return studentRepository.findStudents(id);
	}

	public void saveStudent(Students students) {
		studentRepository.saveStudent(students);
	}
}
