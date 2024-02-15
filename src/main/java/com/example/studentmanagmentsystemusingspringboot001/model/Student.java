package com.example.studentmanagmentsystemusingspringboot001.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter


@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private  int id;

    @Column(name = "name")
    private  String name;
    @Column(name = "email")
    private  String email;

    @Column(name = "mobile")
    private  String mobile;
    @Column(name = "country")
    private  String country;


}
