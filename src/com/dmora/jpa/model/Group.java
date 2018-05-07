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
@Table(name = "groups")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Group.findAll", query = "SELECT g FROM Group g")
    ,
    @NamedQuery(name = "Group.findById", query = "SELECT g FROM Group g WHERE g.id = :id")
    ,
    @NamedQuery(name = "Group.findByCode", query = "SELECT g FROM Group g WHERE g.code = :code")
    ,
    @NamedQuery(name = "Group.deleteGroup", query = "DELETE FROM Group g WHERE g.id = :id")})

public class Group implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Column(name = "code")
    private String code;
    @Column(name = "grade")
    private String grade;
    @Column(name = "level")
    private int lvl;

    public Group(int id, String code, String grade, int level) {
        this.id = id;
        this.code = code;
        this.grade = grade;
        this.lvl = level;
    }

    public Group(String code, String grade, int level) {
        this.code = code;
        this.grade = grade;
        this.lvl = level;
    }

    public Group(int id) {
        this.id = id;
    }

    public Group() {

    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getLevel() {
        return lvl;
    }

    public void setLevel(Integer level) {
        this.lvl = level;
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
        final Group other = (Group) obj;
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
                sb.append(fieldValue.toString());
                sb.append("]");
            } catch (IllegalArgumentException | IllegalAccessException ex) {
                Logger.getLogger(Group.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        sb.append("}");
        return sb.toString();
    }

}
