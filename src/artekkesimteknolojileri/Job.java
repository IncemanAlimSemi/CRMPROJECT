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
public class Job extends Base {

    public Job(String jobCompany, Date jobDate, Date jobEndDate, String jobPerson, String jobComment, Boolean jobIsDone) {
        company = jobCompany;
        date = jobDate;
        endDate = jobEndDate;
        person = jobPerson;
        comment = jobComment;
        isDone = jobIsDone;
    }

    public Job(int ID, String jobCompany, Date jobDate, Date jobEndDate, String jobPerson, String jobComment, Boolean jobIsDone) {
        this.ID = ID;
        company = jobCompany;
        date = jobDate;
        endDate = jobEndDate;
        person = jobPerson;
        comment = jobComment;
        isDone = jobIsDone;
    }
    
    @Override
    public int getID() {
        return ID;
    }

    public String getJobCompany() {
        return company;
    }

    public Date getJobDate() {
        return date;
    }
    
    public Date getJobEndDate() {
        return endDate;
    }

    public String getJobPerson() {
        return person;
    }

    public String getJobComment() {
        return comment;
    }

    public Boolean getJobIsDone() {
        return isDone;
    }
}
