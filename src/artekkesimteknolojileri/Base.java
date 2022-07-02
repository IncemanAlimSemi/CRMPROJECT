/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package artekkesimteknolojileri;

import java.util.Date;

/**
 *
 * @author alims
 */
public class Base {
    
    int ID;
    String company;
    Date date;
    Date endDate;
    String person;
    String comment;
    Boolean isDone; 

    public Base(){
        
    }
    
    public Base(int ID, String company, Date date, Date endDate, String person, String comment, Boolean isDone) {
        this.ID = ID;
        this.company = company;
        this.date = date;
        this.endDate = endDate;
        this.person = person;
        this.comment = comment;
        this.isDone = isDone;
    } 

    public int getID() {
        return ID;
    }

    public String getCompany() {
        return company;
    }

    public Date getDate() {
        return date;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getPerson() {
        return person;
    }

    public String getComment() {
        return comment;
    }

    public Boolean getIsDone() {
        return isDone;
    }
    
    
}
