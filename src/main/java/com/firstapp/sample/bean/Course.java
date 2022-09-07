package com.firstapp.sample.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.File;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "course")
public class Course {
    @NotNull
    @Id
    private int id;
    private String name;
    private String description;
    private File docFile;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    @JoinColumn(name = "student_id", nullable = true)
    private Student student;

    public Course(int id, String name, String description, File docFile, String s_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.docFile = docFile;
        this.student = new Student(s_id, "", "");
    }
}
