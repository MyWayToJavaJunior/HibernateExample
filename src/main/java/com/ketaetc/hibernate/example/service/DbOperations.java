package com.ketaetc.hibernate.example.service;

import com.ketaetc.hibernate.example.dao.StudentDAO;
import com.ketaetc.hibernate.example.pojo.Student;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Author: ketaetc (ketaetc@gmail.com)
 */

public class DbOperations {

    StudentDAO studentDAO = new StudentDAO();

    public static void main(String[] args) {
        DbOperations dbOperations = new DbOperations();
        Student createStudent = dbOperations.createStudent();

        List<Student> studentList = dbOperations.getStudentList();
        if (studentList != null) {
            for (Student student : studentList) {
                System.out.println("Student ID : " + student.getId());
                System.out.println("Student Name : " + student.getName());
                System.out.println("Student Gender : " + student.getGender());
                System.out.println("Student Class : " + student.getClass_());
                System.out.println("Student Rollnumber : " + student.getRollnumber());
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                System.out.println("Student Lastupdated : " + df.format(student.getLastUpdated()));
            }
        }
        dbOperations.updateStudent(createStudent.getId());
        Student student = dbOperations.getStudent(createStudent.getId());
        if (student != null) {
            System.out.println("Student Details After Updation : " + student.getName());
        }

        dbOperations.deleteStudent(createStudent.getId());

    }

    public Student createStudent() {
        Student s = new Student();
        s.setGender((byte)(Math.random()*127));
        s.setName("ketaetc");
        s.setClass_("1");
        s.setRollnumber((int)(Math.random()*2147483647));
        Date curD = Calendar.getInstance().getTime();
        s.setLastUpdated(new Timestamp(curD.getTime()));
        studentDAO.addStudent(s);
        return s;
    }

    public void updateStudent(Integer id) {
        Student student = studentDAO.findStudentById(id);
        student.setName("hibernate example project");
        studentDAO.updateStudent(student);
        System.out.println("Student Updated Success");
    }

    public void deleteStudent(Integer id) {
        studentDAO.deleteStudent(id);
        System.out.println("Student Deleted Success");
    }

    public List<Student> getStudentList() {
        return studentDAO.listStudent();
    }

    public Student getStudent(Integer id) {
        return studentDAO.findStudentById(id);
    }

}