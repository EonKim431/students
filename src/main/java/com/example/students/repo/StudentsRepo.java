package com.example.students.repo;

import com.example.students.dto.SearchDto;
import com.example.students.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentsRepo extends JpaRepository<Students,String> {
    @Query(value = "SELECT \n" +
            "    st.student_no, \n" +
            "    st.name, \n" +
            "    sc.korean, \n" +
            "    sc.math, \n" +
            "    sc.english, \n" +
            "    sc.history, \n" +
            "    SUM(sc.korean + sc.math + sc.english + sc.history) AS total_score, \n" +
            "    SUM(sc.korean + sc.math + sc.english + sc.history) / 4 AS avg_score,\n" +
            "    RANK() OVER (ORDER BY AVG(sc.korean + sc.math + sc.english + sc.history) DESC) AS greater_avg_count\n" +
            "FROM \n" +
            "    students AS st \n" +
            "LEFT JOIN \n" +
            "    score AS sc ON sc.student_no = st.student_no \n" +
            "GROUP BY \n" +
            "    st.student_no, st.name;", nativeQuery = true)
    List<Object[]> searchQuery();

    @Query(value = "select student_no from students",nativeQuery = true)
    List<String> searchId();
}
