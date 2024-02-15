package com.example.studentmanagmentsystemusingspringboot001.service;

import com.example.studentmanagmentsystemusingspringboot001.dao.StudentDao;
import com.example.studentmanagmentsystemusingspringboot001.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentDao studentDao;
    public List<Student> getAllStudent(){
        return (List<Student>)studentDao.findAll();
    }

    public Student saveStudent(Student student){
        return studentDao.save(student);
    }
    public void deleteByid(int id){
        studentDao.deleteById(id);
    }
    public Student updateStudent(Student student){
        return studentDao.save(student);
    }
    public Student getStudentById(int id){
        return studentDao.findById(id).get();
    }


}
