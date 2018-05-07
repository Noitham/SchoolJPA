/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmora.jpa;

import com.dmora.jpa.controller.Controller;
import com.dmora.jpa.model.Model;

/**
 *
 * @author DanielMoralesGonzale
 */
public class SchoolJPA {

    public static void main(String[] args) {
        Model model = new Model();
        Controller control = new Controller(model);
    }

}
