package com.CurdOperation.demo6;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CurdOperation.demo6.Entity.Student;
import com.CurdOperation.demo6.studentService.StudentSer;


@Configuration
@Controller
public class Controler {
	@Autowired
	StudentSer studentserive;

    @GetMapping("/add")
    public String showAddStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "AddStudent";
    }

    @PostMapping("/Process")
   // @ResponseBody
    public String addStudent(@Validated @ModelAttribute("student") Student student, BindingResult result,Model model) {
        if (result.hasErrors()) {
            // If there are validation errors, return to the form with error messages
            return "AddStudent";
        }
        this.studentserive.createStudent(student);
        List<Student> studentList = studentserive.AllStudent();
        model.addAttribute("students", studentList);
        return "Todo"; 
    }
    @PostMapping("/delete/{id}")
   
	public String removeStudent(@PathVariable int id,Model model)
	{
    	studentserive.deleteStudent(id);
    	
        List<Student> studentList = studentserive.AllStudent();
     
        model.addAttribute("students", studentList);
        return "Todo";

	}
    @GetMapping("/update/{id}")
    
 	public String updateStudent(@PathVariable int id,Model model)
 	{
     	model.addAttribute("Id",id);
     	return "update";
 		

 	}
    @GetMapping("/check")
    public String check(Model model)
    {
    	 List<Student> studentList = studentserive.AllStudent();
         model.addAttribute("students", studentList);
    	return "Todo";
    }

}
