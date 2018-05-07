/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmora.jpa.persist;

import com.dmora.jpa.model.Group;
import com.dmora.jpa.model.Student;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * @author dmora
 */
public class StudentDAO {

    Logger logger = Logger.getLogger("com.dmora.jpa");
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("SchoolJPAPU");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    public StudentDAO() {

        tx.begin();

    }

    /**
     * Retrieves all students from the database
     *
     * @return all students from the database
     */
    public List<Student> listAll() {

        logger.setLevel(Level.SEVERE);
        System.out.println("Testing categories persistence.");

        Query query;
        java.util.List<Student> lst;

        System.out.println("Named query");
        query = em.createNamedQuery("Student.findAll");
        lst = query.getResultList();

        return lst;
    }

    /**
     * Adds a new student to the Database
     *
     * @param student to add
     * @return 1 is student added or 0 if not.
     */
    public int insert(Student student) {

        int num = 0;
        try {

            logger.setLevel(Level.SEVERE);
            System.out.println("Testing categories persistence.");

            //create a new Student.  
            Student s = new Student(student.getName(), student.getAge());
            em.persist(s);
            tx.commit();

            num = 1;

        } catch (SecurityException ex) {
            System.out.println(ex.getMessage());
        }

        return num;

    }

    /**
     * Finds a student by the given id
     *
     * @param id to search
     * @return 1 if student found or 0 if not.
     */
    public Student findById(Long id) {

        Student student = null;

        try {

            logger.setLevel(Level.SEVERE);
            System.out.println("Testing categories persistence.");

            Query query;

            System.out.println("Named query");
            query = em.createNamedQuery("Student.findById");
            query.setParameter("id", id);

            java.util.List<Student> lst = query.getResultList();

            student = lst.get(0);

        } catch (SecurityException ex) {
            System.out.println("Exception: " + ex);
        }

        return student;
    }

    /**
     * Modifies a student that we previously searched by name from database
     *
     * @param olds olds
     * @param news news
     * @return 1 if product modified or 0 if not.
     */
    public int update(Student olds, Student news) {

        int num = 0;

        try {

            logger.setLevel(Level.SEVERE);
            System.out.println("Testing categories persistence.");

            //Update a Group
            Student s = em.find(com.dmora.jpa.model.Student.class, olds.getId());
            s.setName(news.getName());
            s.setAge(news.getAge());
            em.merge(s);

            tx.commit();

            num = 1;

        } catch (SecurityException ex) {
            System.out.println(ex.getMessage());
        }

        return num;

    }

    /**
     * Deletes a student from the database
     *
     * @param student to add
     * @return the student deleted
     */
    public int delete(Student student) {

        int num = 0;

        try {

            logger.setLevel(Level.SEVERE);
            System.out.println("Testing categories persistence.");

            if (!em.contains(student)) {
                student = em.merge(student);
            }

            em.remove(student);

            tx.commit();

            num = 1;

        } catch (SecurityException ex) {
            System.out.println(ex.getMessage());
            num = 0;
        }

        return num;
    }

    /**
     * Retrieves students from a group from the database
     *
     * @param group group
     * @return students from the database
     */
    public List<Student> listStudentsFromAGroup(Group group) {

        logger.setLevel(Level.SEVERE);
        System.out.println("Testing categories persistence.");

        Query query;

        System.out.println("Named query");
        query = em.createNamedQuery("Student.findByGroupid");
        query.setParameter("groupid", group.getId());

        java.util.List<Student> lst = query.getResultList();

        return lst;

    }

    /**
     * Modifies a student that we previously searched by name from database
     *
     * @param student student
     * @param group group
     * @return 1 if group modified or 0 if not.
     */
    public int enroll(Student student, Group group) {

        int num = 0;

        try {

            logger.setLevel(Level.SEVERE);
            System.out.println("Testing categories persistence.");

            student.setGroupid(group.getId());
            em.merge(student);

            tx.commit();

            num = 1;

        } catch (SecurityException ex) {
            System.out.println(ex.getMessage());
        }

        return num;

    }

    /**
     * Modifies a student that we previously searched by name from database
     *
     * @param student student
     * @return 1 if group modified or 0 if not.
     */
    public int unroll(Student student) {

        int num = 0;

        try {

            logger.setLevel(Level.SEVERE);
            System.out.println("Testing categories persistence.");

            student.setGroupid(null);
            em.merge(student);

            tx.commit();

            num = 1;

        } catch (SecurityException ex) {
            System.out.println(ex.getMessage());
        }

        return num;

    }

    public static void showList(java.util.List lst) {
        if (lst != null) {
            for (Object o : lst) {
                System.out.println(o.toString());
            }
        }
    }

}
