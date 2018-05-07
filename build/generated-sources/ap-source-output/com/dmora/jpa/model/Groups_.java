package com.dmora.jpa.model;

import com.dmora.jpa.model.Students;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-19T13:05:26")
@StaticMetamodel(Groups.class)
public class Groups_ { 

    public static volatile SingularAttribute<Groups, String> code;
    public static volatile SingularAttribute<Groups, Integer> lvl;
    public static volatile SingularAttribute<Groups, String> grade;
    public static volatile SingularAttribute<Groups, Integer> id;
    public static volatile ListAttribute<Groups, Students> studentsList;

}