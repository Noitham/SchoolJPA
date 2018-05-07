package com.dmora.jpa.views;

public class SchoolMenu extends Menu {

    public SchoolMenu() {
        super("Menu");
        addOption(new Option("Exit", "exit"));
        addOption(new Option("List groups", "listgroups"));
        addOption(new Option("Add group", "addgroup"));
        addOption(new Option("Modify group", "modifygroup"));
        addOption(new Option("Delete group", "deletegroup"));
        addOption(new Option("List all students", "liststudents"));
        addOption(new Option("List students of a group", "liststudentsgroups"));
        addOption(new Option("Add student", "addstudent"));
        addOption(new Option("Modify student", "modifystudent"));
        addOption(new Option("Delete student", "deletestudent"));
        addOption(new Option("Enroll student in a group", "enrollstudent"));
        addOption(new Option("Unroll student from a group", "unrollestudent"));
    }

}
