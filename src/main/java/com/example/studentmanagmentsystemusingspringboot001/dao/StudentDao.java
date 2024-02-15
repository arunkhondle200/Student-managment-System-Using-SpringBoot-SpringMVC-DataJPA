package com.example.studentmanagmentsystemusingspringboot001.dao;

import com.example.studentmanagmentsystemusingspringboot001.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDao extends JpaRepository<Student, Integer> {
}
