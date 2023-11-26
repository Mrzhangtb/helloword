package com.iweb.DAO;/*
 * @author Zhang
 * @date 2023/11/25 1:08
 */

import com.iweb.entity.Student;

import java.util.List;

public interface StudentDAO {
    void insert(Student student);
    void delete(Integer id);
    void update(Student student);
    List<Student> listByPage(String key, Integer start, Integer count);
}