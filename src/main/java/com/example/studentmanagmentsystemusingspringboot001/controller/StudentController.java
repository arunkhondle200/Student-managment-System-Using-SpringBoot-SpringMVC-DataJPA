package com.example.studentmanagmentsystemusingspringboot001.controller;

import com.example.studentmanagmentsystemusingspringboot001.model.Student;
import com.example.studentmanagmentsystemusingspringboot001.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public  String listStudent(Model model){
        model.addAttribute("students",studentService.getAllStudent());
        return "students";
    }

    @GetMapping("/students/new")
public String ctrateStudent(Model model){
    Student student =new Student();
    model.addAttribute("student" ,student);
    return "createStudent";
}
    @PostMapping ("/students")
    public String saveStudent(@ModelAttribute("student") Student student){
       studentService.saveStudent(student);
       return "redirect:/students";
    }
    @GetMapping("/students/edit/{id}")
    public String editStudent(@PathVariable int id, Model model){
model.addAttribute("student", studentService.getStudentById(id));
return "editStudent";
    }

    @PostMapping("students/{id}")
    public String updateStudent(@PathVariable int id,@ModelAttribute("student") Student student, Model model){
        Student oldStudent =studentService.getStudentById(id);
        oldStudent.setId(id);
        oldStudent.setName(student.getName());
        oldStudent.setEmail(student.getEmail());
        oldStudent.setMobile(student.getMobile());
        oldStudent.setCountry(student.getCountry());

        studentService.updateStudent(oldStudent);
        return "redirect:/students";

    }
    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentService.deleteByid(id);
        return "redirect:/students";
    }



}
