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
@AllArgsConstructor
@NoArgsConstructor
public class NewCourse {
    @Id
    @NotNull
    private int id;
    @Column
    private String name;
    @Column
    private int age;
    @Column
    private String area;
}
