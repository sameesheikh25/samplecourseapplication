package com.firstapp.sample.repository;


import com.firstapp.sample.bean.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    public List<Course> findCourseByStudentId(String id);

    @Modifying
    @Query("delete from Course c where c.student.id = :s_id and c.id = :id")
    @Transactional
    public void disEnrollCoursesByStudentId(String s_id, Integer id);
}
