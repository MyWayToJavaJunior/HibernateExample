package com.ketaetc.hibernate.example.pojo;

import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Author: ketaetc (ketaetc@gmail.com)
 */

@Entity
@Table(name = "student", catalog = "HibernateExample"
)
public class Student implements java.io.Serializable {

    private Integer id;
    private String name;
    private Integer rollnumber;
    private Byte gender;
    private String class_;
    private Date lastupdated;

    public Student() {
    }

    public Student(String name, Integer rollnumber, Byte gender, String class_, Date lastupdated) {
        this.name = name;
        this.rollnumber = rollnumber;
        this.gender = gender;
        this.class_ = class_;
        this.lastupdated = lastupdated;
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRollnumber() {
        return this.rollnumber;
    }

    public void setRollnumber(Integer rollnumber) {
        this.rollnumber = rollnumber;
    }

    public Byte getGender() {
        return this.gender;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }

    public String getClass_() {
        return this.class_;
    }

    public void setClass_(String class_) {
        this.class_ = class_;
    }

    public Date getLastUpdated() {
        return this.lastupdated;
    }

    public void setLastUpdated (Timestamp lastupdated) {
        this.lastupdated = new Date(lastupdated.getTime());
    }

}