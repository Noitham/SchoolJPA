package com.dmora.jpa.views;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import com.dmora.jpa.controller.Controller;
import com.dmora.jpa.model.Group;
import com.dmora.jpa.model.Model;
import com.dmora.jpa.model.Student;

public class View {

    List<Student> student;
    private Controller control;
    private Model model;
    private SchoolMenu menu;
    private boolean exit = false;

    //Constructor
    public View(Controller control, Model model) {
        this.control = control;
        this.model = model;
        this.menu = new SchoolMenu();
    }

    public boolean isExit() {
        return exit;
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }

    /**
     * Show the Menu
     */
    public void displayMenu() {
        do {
            menu.show();
            String action = menu.getSelectedOptionActionCommand();
            control.processAction(action);
        } while (!exit);
    }

    /**
     * Show alert message.
     *
     * @param s message
     */
    public void alert(String s) {
        System.out.print(s);
    }

    /**
     * Displays a list of objects.
     *
     * @param lst list of objects
     */
    public void displayList(List lst) {
        for (Object o : lst) {
            System.out.println(o.toString());
        }
    }

    /**
     * This methods reads a string from the user and returns it.
     *
     * @param string string
     * @return string
     */
    public String inputString(String string) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        alert(string);
        try {
            s = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

    /**
     * Input new data student.
     *
     * @return new student
     */
    public Student inputStudent() {
        Student student;
        String name;
        int age;
        int groupid;

        try {
            Scanner scan = new Scanner(System.in);
            System.out.printf("Introduce name: ");
            name = scan.nextLine();
            System.out.printf("Introduce age: ");
            age = scan.nextInt();
            student = new Student(name, age);
        } catch (NumberFormatException ex) {
            System.out.printf(ex.getMessage());
            student = null;
        }
        return student;
    }

    /**
     * Input new data group.
     *
     * @return new group
     */
    public Group inputGroup() {
        Group group;
        String code;
        String grade;
        int level;
        try {
            Scanner scan = new Scanner(System.in);
            System.out.printf("Introduce code: ");
            code = scan.nextLine();
            System.out.printf("Introduce grade: ");
            grade = scan.nextLine();
            System.out.printf("Introduce level: ");
            level = scan.nextInt();
            group = new Group(code, grade, level);
        } catch (NumberFormatException ex) {
            System.out.printf(ex.getMessage());
            group = null;
        }
        return group;

    }

    /**
     * Method that will display group grouplist.
     *
     * @param grouplist grouplist
     */
    public void displayGroupList(List<Group> grouplist) {

        if (grouplist != null) {
            for (Object o : grouplist) {
                System.out.println(o.toString());
            }
        } else {
            System.out.printf("No groups found");
        }
    }

    /**
     * Method that will display studentlist list.
     *
     * @param studentlist studentlist
     */
    public void displayStudentList(List<Student> studentlist) {

        if (studentlist != null) {
            //Print result
            System.out.println(studentlist.toString());
        } else {//studentlist is null
            System.out.println("No students found");
        }
    }

}
