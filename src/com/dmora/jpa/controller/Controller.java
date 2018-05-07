/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmora.jpa.controller;

import com.dmora.jpa.model.Group;
import com.dmora.jpa.model.Model;
import com.dmora.jpa.model.Student;
import com.dmora.jpa.views.View;
import java.util.List;

/**
 *
 * @author DanielMoralesGonzale
 */
public class Controller {

    private Model model;
    private View view;

    /**
     * Constructor
     *
     * @param model model
     */
    public Controller(Model model) {
        this.model = model;
        this.view = new View(this, model);
        view.displayMenu();
    }

    /**
     * Selects the option from the view
     *
     * @param action action
     */
    public void processAction(String action) {
        switch (action) {
            case "exit": // Exit to the app
                view.setExit(true);
                break;
            case "listgroups": // List Group
                listAllGroups();
                break;
            case "addgroup": // Add New Group
                createNewGroup();
                break;
            case "modifygroup": // Modify Group
                modifyGroup();
                break;
            case "deletegroup": // delete Group
                deleteGroup();
                break;
            case "liststudents": // List all students
                listAllStudents();
                break;
            case "liststudentsgroups": // List students of group
                listAllStudentsInAGroup();
                break;
            case "addstudent": // Add new student
                createNewStudent();
                break;
            case "modifystudent": // Modify student
                modifyStudent();
                break;
            case "deletestudent": // Delete student
                deleteStudent();
                break;
            case "enrollstudent": // Assign a group
                // TODO
                enrollStudentInGroup();
                break;
            case "unrollestudent": // Unassign group
                // TODO
                unEnrollStudentInGroup();
                break;
            default:
                view.alert("Unknown error\n");
                break;
        }
    }

    /**
     * Gets all groups from the data source.
     * {@link bdmvcschool.model.Model#listAllGroups()}
     */
    public void listAllGroups() {
        model.listAllGroups();
    }

    /**
     * Gets all groups from the data source. {@link Model#listAllStudents()} ()}
     */
    public void listAllStudents() {
        model.listAllStudents();
    }

    /**
     * Method that will ask user the needed data for creating a new group. We
     * will comprove that a group with the given id doesn't exists. If it does,
     * we will show error. If it doesn't, we will send the data to the
     * controller. Which will use model for creating the new group.
     * <p>
     * uses
     * {@link bdmvcschool.model.Model#createNewGroup(bdmvcschool.model.Group)}
     */
    public void createNewGroup() {
        Group group = view.inputGroup();
        if (group != null) {
            model.createNewGroup(group);
        }
    }

    /**
     * Method that will ask user the needed data for creating a new student. We
     * will comprove that a student with the given id doesn't exists. If it
     * does, we will show error, if it doesn't, we will send the data to the
     * controller. Which will use model for creating the new student.
     * <p>
     * uses
     * {@link bdmvcschool.model.Model#createNewStudent(bdmvcschool.model.Student)}
     */
    public void createNewStudent() {
        Student student = view.inputStudent();
        if (student != null) {
            model.createNewStudent(student);
        }
    }

    /**
     * Method that will ask user the id of the group to modify. If the group
     * exists, we will show it. If not, we will show error message. We will ask
     * for user for confirmation. If confirm, we will send the data to the
     * controller. Which will use the model for modifying the group.
     * <p>
     * uses {@link Model#modifyGroup(Group)}, {@link Model#searchGroupById(long)}
     * }
     */
    public void modifyGroup() {
        long id = Long.parseLong(view.inputString("Input id: "));
        if (id > 0) {
            Group group = model.searchGroupById(id);
            Group newGroup;
            if (group != null) {
                view.alert(group.toString());
                String answer = view.inputString("Would you like to modify this group? (Y/N)");
                if (answer.equals("Y") || answer.equals("y")) {
                    newGroup = view.inputGroup();
                    group.setCode(newGroup.getCode());
                    group.setGrade(newGroup.getGrade());
                    group.setLevel(newGroup.getLevel());
                    model.modifyGroup(group, newGroup);
                } else {
                    view.alert("Aborted");
                }
            } else {
                view.alert("Group could not be found");
            }
        } else {
            view.alert("ID not found");
        }
    }

    /**
     * Method that will ask user the id of the student to modify. If the student
     * exists, we will show it. If not, we will show error message. We will ask
     * for user for confirmation. If confirm, we will send the data to the
     * controller. Which will use the model for modifying the student.
     * <p>
     * uses {@link bdmvcschool.model.Model#modifyStudent(bdmvcschool.model.Student), {@link bdmvcschool.model.Model#searchStudentById(long)
     * }
     */
    public void modifyStudent() {
        long id = Long.parseLong(view.inputString("Input id: "));
        if (id > 0) {
            Student student = model.searchStudentById(id);
            Student newStudent;
            if (student != null) {
                view.alert(student.toString());
                String answer = view.inputString("Would you like to modify this student? (Y/N)");
                if (answer.equals("Y") || answer.equals("y")) {
                    newStudent = view.inputStudent();
                    student.setName(newStudent.getName());
                    student.setAge(newStudent.getAge());
                    model.modifyStudent(student, newStudent);
                } else {
                    view.alert("Aborted");
                }
            } else {
                view.alert("Student could not be found");
            }
        } else {
            view.alert("ID not found");
        }
    }

    /**
     * Method that will ask user the id of the group to delete. If the group
     * exists, we will show it. If not, we will show error message. We will ask
     * for user for confirmation. If confirm, we will send the data to the
     * controller. Which will use the model for removing the group.
     * <p>
     * uses {@link Controller#deleteGroup()}
     * }
     */
    public void deleteGroup() {
        long id = Long.parseLong(view.inputString("Input id: "));
        if (id > 0) {
            Group group = model.searchGroupById(id);
            if (group != null) {
                view.alert(group.toString());
                String answer = view.inputString("Would you like to delete this group? (Y/N)");
                if (answer.equals("Y") || answer.equals("y")) {
                    model.deleteGroup(group);
                } else {
                    view.alert("Aborted");
                }
            } else {
                view.alert("Group could not be found");
            }
        } else {
            view.alert("ID not found");
        }
    }

    /**
     * Method that will ask user the id of the student to delete. If the student
     * exists, we will show it. If not, we will show error message. We will ask
     * for user for confirmation. If confirm, we will send the data to the
     * controller. Which will use the model for removing the student.
     * <p>
     * uses {@link Controller#deleteStudent()} (bdmvcschool.model.Student) }
     */
    public void deleteStudent() {
        long id = Long.parseLong(view.inputString("Input id: "));
        if (id > 0) {
            Student student = model.searchStudentById(id);
            if (student != null) {
                view.alert(student.toString());
                String answer = view.inputString("Would you like to delete this student? (Y/N)");
                if (answer.equals("Y") || answer.equals("y")) {
                    model.deleteStudent(student);
                } else {
                    view.alert("Aborted");
                }
            } else {
                view.alert("Student could not be found");
            }
        } else {
            view.alert("ID not found");
        }
    }

    /**
     * Method that will ask user the id of the group to show(its students). If a
     * group with the given id exists, we will show it. If not, we will show
     * error message. We will ask for user for confirmation. If confirm, we will
     * send the data to the controller. Which will use the model for modifying
     * the student.
     * <p>
     * uses {@link bdmvcschool.model.Model#listAllStudentsInAGroup(bdmvcschool.model.Group)
     * }
     */
    public void listAllStudentsInAGroup() {

        long id = Long.parseLong(view.inputString("Input the group id: "));

        Group group = model.searchGroupById(id);

        if (group != null) {

            List studentlist = model.listAllStudentsInAGroup(group);

            view.displayList(studentlist);

        } else {

            view.alert("No group found");

        }

    }

    /**
     * Method that will ask user the id of the student to enroll into a group.
     * If the student exists, we will show it. If not, we will show error
     * message. We will ask for user for confirmation. If confirm, we will send
     * the data to the controller. Which will use model for enrolling the
     * student to the group.
     * <p>
     * uses {@link bdmvcschool.model.Model#enrollStudentInGroup(bdmvcschool.model.Student, bdmvcschool.model.Group)
     * }
     */
    public void enrollStudentInGroup() {
        long ids = Long.parseLong(view.inputString("Input student id: "));
        long idg = Long.parseLong(view.inputString("Input group id: "));
        if (idg > 0) {
            if (ids > 0) {
                Student student = model.searchStudentById(ids);
                Group group = model.searchGroupById(idg);
                if (student != null) {
                    if (group != null) {
                        view.alert(student.toString());
                        String answer = view.inputString("Would you like to modify this student? (Y/N)");
                        if (answer.equals("Y") || answer.equals("y")) {
                            model.enrollStudentInGroup(student, group);
                        } else {
                            view.alert("Aborted");
                        }
                    } else {
                        view.alert("Group could not be found");
                    }
                } else {
                    view.alert("Student could not be found");
                }
            } else {
                view.alert("Student not be found");
            }
        } else {
            view.alert("Groupid not found");
        }
    }

    /**
     * Method that will ask user the id of the student to unenroll from a group.
     * If the student exists, we will show it. If not, we will show error
     * message. We will ask for user for confirmation. If confirm, we will send
     * the data to the controller. Which will use model for unenrolling the
     * student to the group.
     * <p>
     * uses {@link bdmvcschool.model.Model#unEnrollStudentInGroup(bdmvcschool.model.Student, bdmvcschool.model.Group)
     * }
     */
    public void unEnrollStudentInGroup() {
        long ids = Long.parseLong(view.inputString("Input student id: "));
        if (ids > 0) {
            Student student = model.searchStudentById(ids);
            if (student != null) {
                view.alert(student.toString());
                String answer = view.inputString("Would you like to modify this student? (Y/N)");
                if (answer.equals("Y") || answer.equals("y")) {
                    model.unEnrollStudentInGroup(student);
                } else {
                    view.alert("Aborted");
                }
            } else {
                view.alert("Student could not be found");
            }
        } else {
            view.alert("ID could not be found");
        }
    }

}
