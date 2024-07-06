package com.example.springmybatis.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.springmybatis.domain.Students;

@Mapper
public interface StudentMapper {
	int countStudents();

	List<Students> findStudents(@Param("id") Long id);	// SELECT * FROM students WHERE id = #{id}

	void saveStudent(Students students);
}
