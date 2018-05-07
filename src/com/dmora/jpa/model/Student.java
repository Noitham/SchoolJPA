/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmora.jpa.model;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DanielMoralesGonzale
 */
@Entity
@Table(name = "students")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s")
    ,
    @NamedQuery(name = "Student.findById", query = "SELECT s FROM Student s WHERE s.id = :id")
    ,
    @NamedQuery(name = "Student.findByName", query = "SELECT s FROM Student s WHERE s.name = :name")
    ,
    @NamedQuery(name = "Student.findByAge", query = "SELECT s FROM Student s WHERE s.age = :age")
    ,
    @NamedQuery(name = "Student.findByGroupid", query = "SELECT s FROM Student s WHERE s.groupid = :groupid")})

public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private Integer age;
    @Column(name = "groupid")
    private Integer groupid;

    public Student() {
    }

    public Student(Integer id, String name, Integer age, Integer groupid) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.groupid = groupid;
    }

    public Student(String name, Integer age, Integer groupid) {
        this.name = name;
        this.age = age;
        this.groupid = groupid;
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGroupid() {
        return groupid;
    }

    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        Class classObj = getClass();
        String className = classObj.getSimpleName();
        sb.append(className).append(" {");
        Field[] fields = classObj.getDeclaredFields();
        for (Field f : fields) {
            String fieldName = f.getName();
            try {
                Object fieldValue = f.get(this);
                sb.append("[");
                sb.append(fieldName).append("=");
                if (fieldValue != null) {
                    sb.append(fieldValue.toString());
                } else {
                    sb.append(fieldValue);
                }
                sb.append("]");
            } catch (IllegalArgumentException | IllegalAccessException ex) {
                Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        sb.append("}");
        return sb.toString();
    }

}
