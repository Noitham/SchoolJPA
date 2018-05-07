/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmora.jpa.persist;

import com.dmora.jpa.model.Group;
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
public class GroupDAO {

    Logger logger = Logger.getLogger("com.dmora.jpa");
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("SchoolJPAPU");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    public GroupDAO() {

        tx.begin();

    }

    /**
     * Retrieves all groups from the database
     *
     * @return grouplist
     */
    public List<Group> listAll() {

        logger.setLevel(Level.SEVERE);
        System.out.println("Testing categories persistence.");

        List<Group> grouplist;

        Query query;

        System.out.println("Named query");
        query = em.createNamedQuery("Group.findAll");
        grouplist = query.getResultList();

        return grouplist;

    }

    /**
     * Adds a new group to the Database
     *
     * @param group to add
     * @return 1 if student added or 0 if not.
     */
    public int insert(Group group) {

        int num = 0;

        try {

            logger.setLevel(Level.SEVERE);
            System.out.println("Testing categories persistence.");

            //create a new Group.  
            Group g = new Group(group.getCode(), group.getGrade(), group.getLevel());
            em.persist(g);
            tx.commit();

            num = 1;

        } catch (SecurityException ex) {
            System.out.println(ex.getMessage());
        }

        return num;
    }

    /**
     * Finds a group by the given code
     *
     * @param id to search
     * @return 1 if group found or 0 if not.
     */
    public Group findById(long id) {

        Group group = null;

        try {

            logger.setLevel(Level.SEVERE);
            System.out.println("Testing categories persistence.");

            Query query;

            System.out.println("Named query");
            query = em.createNamedQuery("Group.findById");
            query.setParameter("id", id);

            java.util.List<Group> lst = query.getResultList();

            group = lst.get(0);

        } catch (SecurityException ex) {
            System.out.println("Exception: " + ex);
        }

        return group;

    }

    /**
     * Modifies a group that we previously searched by code from database
     *
     * @param oldg oldg
     * @param newg newg
     * @return 1 if product modified or 0 if not.
     */
    public int update(Group oldg, Group newg) {

        int num = 0;

        try {

            logger.setLevel(Level.SEVERE);
            System.out.println("Testing categories persistence.");

            //Update a Group
            Group g = em.find(com.dmora.jpa.model.Group.class, oldg.getId());
            g.setCode(newg.getCode());
            g.setGrade(newg.getGrade());
            g.setLevel(newg.getLevel());
            em.merge(g);

            tx.commit();

            num = 1;

        } catch (SecurityException ex) {
            System.out.println(ex.getMessage());
        }

        return num;

    }

    /**
     * Deletes a group from the database
     *
     * @param group to add
     * @return the group deleted
     */
    public int delete(Group group) {

        int num = 0;

        try {

            logger.setLevel(Level.SEVERE);
            System.out.println("Testing categories persistence.");

            if (!em.contains(group)) {
                group = em.merge(group);
            }

            em.remove(group);

            tx.commit();

            num = 1;

        } catch (SecurityException ex) {
            System.out.println(ex.getMessage());
            num = 0;
        }

        return num;

    }
}
