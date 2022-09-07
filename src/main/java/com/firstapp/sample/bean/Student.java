package com.firstapp.sample.bean;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @NotNull
    @Column(name="student_id")
    private String id;
    private String name;
    private String email;
//    @OneToMany(mappedBy = "student")
//    private Set<Course> courseSet;
}
