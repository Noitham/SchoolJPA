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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @NamedQuery(name = "Students.findAll", query = "SELECT s FROM Students s")
    ,
    @NamedQuery(name = "Students.findById", query = "SELECT s FROM Students s WHERE s.id = :id")
    ,
    @NamedQuery(name = "Students.findByName", query = "SELECT s FROM Students s WHERE s.name = :name")
    ,
    @NamedQuery(name = "Students.findByAge", query = "SELECT s FROM Students s WHERE s.age = :age")
    ,
    @NamedQuery(name = "Students.findByGroupId", query = "SELECT s FROM Students s WHERE s.groupid = :groupid")})

public class Students implements Serializable {

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

    public Students() {
    }

    public Students(Integer id, String name, Integer age, Integer groupid) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.groupid = groupid;
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
        final Students other = (Students) obj;
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
                sb.append(fieldName + "=");
                sb.append(fieldValue.toString());
                sb.append("]");
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        sb.append("}");
        return sb.toString();
    }

}
