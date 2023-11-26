package com.iweb.DAO.Impl;/*
 * @author Zhang
 * @date 2023/11/25 1:09
 */

import com.iweb.DAO.StudentDAO;
import com.iweb.DBUtil.DBUtil;
import com.iweb.entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    public void insert(Student student) {
        String sql = "insert into student(name,gender,birthday,address,qqnumber) " +
                "values(?,?,?,?,?)";
        try(Connection c = DBUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
        ){
            ps.setString(1,student.getName());
            ps.setString(2,student.getGender());
            ps.setDate(3,  new Date(student.getBirthday().getTime()));
            ps.setString(4,student.getAddress());
            ps.setInt(5,student.getQqnumber());
            ps.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(Integer id) {
        String sql = "delete from student where id = " + id;
        try (Connection c = DBUtil.getConnection();
             Statement s = c.createStatement();
        ) {
            s.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Student student) {
        String sql = "update student set name = ?,gender = ?,birthday = ?,address = ?,qqnumber = ? where id = ?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, student.getName());
            ps.setString(2, student.getGender());
            ps.setDate(3, new Date(student.getBirthday().getTime()));
            ps.setString(4, student.getAddress());
            ps.setLong(5, student.getQqnumber());
            ps.setInt(6, student.getId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Student> listByPage(String key, Integer start, Integer count) {
        List<Student> stus = new ArrayList<>();
        String sql;
        if (key == null || key == "") {
            sql = "select * from student limit ?,?";
        } else {
            sql = "select * from student where name like concat('%',?,'%') limit ?,?";
        }
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
        ) {
            if (key == null || key == "") {
                ps.setInt(1, start);
                ps.setInt(2, count);
            } else {
                ps.setString(1, key);
                ps.setInt(2, start);
                ps.setInt(3, count);
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setGender(rs.getString("gender"));
                s.setBirthday(rs.getDate("birthday"));
                s.setAddress(rs.getString("address"));
                s.setQqnumber(rs.getInt("qqnumber"));
                stus.add(s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return stus.isEmpty() ? null : stus;
    }
}
