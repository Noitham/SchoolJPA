/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmora.jpa.model;

import com.dmora.jpa.persist.GroupDAO;
import com.dmora.jpa.persist.StudentDAO;
import java.util.List;

/**
 *
 * @author DanielMoralesGonzale
 */
public class Model {

    //DAO
    private StudentDAO studentdao;
    private GroupDAO groupdao;

    // Constructors.
    public Model() {

        studentdao = new StudentDAO();
        groupdao = new GroupDAO();

    }

    // Methods to manage data.
    /**
     * Method for listing all groups. This method will be called by the
     * controller. It will manipulate the data, and return it to the view, which
     * will be the one that will show it to the user.
     */
    public void listAllGroups() {

        List<Group> resultList = groupdao.listAll();

        showList(resultList);

    }

    /**
     * Method listing all students. This method will be called by the
     * controller. It will manipulate the data, and return it to the view, which
     * will be the one that will show it to the user.
     */
    public void listAllStudents() {

        List<Student> resultList = studentdao.listAll();

        showList(resultList);

    }

    /**
     * Method for creating a new group. This method will be called by the
     * controller. It will manipulate the data, and return it to the view, which
     * will be the one that will show it to the user.
     *
     * @param group to add
     */
    public void createNewGroup(Group group) {

        if (groupdao.insert(group) == 1) {

            System.out.println("Insertion OK");

        } else {
            System.out.println("Fail insert");

        }

    }

    /**
     * Method for creating a new student. This method will be called by the
     * controller. It will manipulate the data, and return it to the view, which
     * will be the one that will show it to the user.
     *
     * @param student to add
     */
    public void createNewStudent(Student student) {

        if (studentdao.insert(student) == 1) {

            System.out.println("Insertion OK");

        } else {
            System.out.println("Fail insert");

        }

    }

    /**
     * Search a group by the given id.
     *
     * @param id to find
     * @return data source with a group with the given code or null if not found
     */
    public Group searchGroupById(long id) {

        Group found = null;

        try {
            found = groupdao.findById(id);
        } catch (Exception ex) {
            System.out.println("Student doesn't exist");
        }

        return found;

    }

    /**
     * Search a student by the given id.
     *
     * @param id to find
     * @return data source with a group with the given code or null if not found
     */
    public Student searchStudentById(Long id) {

        Student found = null;

        try {
            found = studentdao.findById(id);
        } catch (Exception ex) {
            System.out.println("Student doesn't exist");
        }

        return found;

    }

    /**
     * Method for modifying a existing group. This method will be called by the
     * controller. It will manipulate the data, and return it to the view, which
     * will be the one that will show it to the user.
     *
     * @param oldg oldg
     * @param newg newg
     */
    public void modifyGroup(Group oldg, Group newg) {

        if (groupdao.update(oldg, newg) == 1) {
            System.out.println("Modified OK");

        } else {
            System.out.println("Fail modify");

        }

    }

    /**
     * Method for modifying a existing student. This method will be called by
     * the controller. It will manipulate the data, and return it to the view,
     * which will be the one that will show it to the user.
     *
     * @param olds olds
     * @param news news
     */
    public void modifyStudent(Student olds, Student news) {

        if (studentdao.update(olds, news) == 1) {
            System.out.println("Modified OK");

        } else {
            System.out.println("Fail modify");

        }

    }

    /**
     * Method for removing an existing group. This method will be called by the
     * controller. It will manipulate the data, and return it to the view, which
     * will be the one that will show it to the user.
     *
     * @param group to delete
     */
    public void deleteGroup(Group group) {

        if (groupdao.delete(group) == 1) {

            System.out.println("Delete OK");

        } else {

            System.out.println("Fail delete");
        }

    }

    /**
     * Method for removing a existing student. This method will be called by the
     * controller. It will manipulate the data, and return it to the view, which
     * will be the one that will show it to the user.
     *
     * @param student to add
     */
    public void deleteStudent(Student student) {

        if (studentdao.delete(student) == 1) {

            System.out.println("Delete OK");

        } else {

            System.out.println("Fail delete");
        }

    }

    /**
     * Method for listing all students in a group. This method will be called by
     * the controller. It will manipulate the data, and return it to the view,
     * which will be the one that will show it to the user.
     *
     * @param group to be searched
     * @return resultlist resultlist
     */
    public List<Student> listAllStudentsInAGroup(Group group) {

        List<Student> resultlist = studentdao.listStudentsFromAGroup(group);

        return resultlist;

    }

    /**
     * Method for enrolling a existing student in a group. This method will be
     * called by the controller. It will manipulate the data, and return it to
     * the view, which will be the one that will show it to the user.
     *
     * @param student to enroll
     * @param group where we'll add the student
     */
    public void enrollStudentInGroup(Student student, Group group) {

        if (studentdao.enroll(student, group) == 1) {
            
            System.out.println("Enroll OK");
            
        } else {
            
            System.out.println("Fail enroll");
            
        }
    }

    /**
     * Method for unenrolling a existing student from a group. This method will
     * be called by the controller. It will manipulate the data, and return it
     * to the view, which will be the one that will show it to the user.
     *
     * @param student to unenroll
     */
    public void unEnrollStudentInGroup(Student student) {

        if (studentdao.unroll(student) == 1) {

            System.out.println("Enroll OK");

        } else {

            System.out.println("Fail unenroll");

        }
    }

    /**
     * Method that will display list.
     *
     * @param lst
     */
    public static void showList(java.util.List lst) {

        if (lst != null) {
            lst.forEach((o) -> {
                System.out.println(o.toString());
            });
        }
    }

}
