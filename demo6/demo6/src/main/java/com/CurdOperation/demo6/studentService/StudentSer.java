package com.CurdOperation.demo6.studentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.CurdOperation.demo6.Entity.Student;
import com.CurdOperation.demo6.sR.SR;
@Configuration
public class StudentSer {
	@Autowired
	SR sR;

	public void createStudent(Student student) {
		// TODO Auto-generated method stub
		sR.save(student);
		
	}
	public List<Student> AllStudent()
	{
		return sR.findAll();
	}
	public void deleteStudent(int rollNo) {
		// TODO Auto-generated method stub
		sR.deleteById(rollNo);		
	}

}
