/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package artekkesimteknolojileri;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author alims
 */
public class DbUse {
    
    static User user;
    Connection connection = null;
    DbHelper dbHelper = new DbHelper();
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet;
    
    public boolean getUser(String id, String password) throws SQLException{
        try {
           resultSet = DbHelper.getData("SELECT * FROM users WHERE USERNAME = '" + id +"' AND PASSWORD = '" + password +"'");
           if(resultSet.next()){
               user = new User(resultSet.getString("USERNAME"), resultSet.getString("PASSWORD"), resultSet.getString("NAMEOFUSERS"));
               return true;
           }
        } catch (SQLException exception) {
            DbHelper.showErrorMessage(exception);
        }
        return false;
    }

    public void addJob(Job job) throws SQLException {
        try {
            preparedStatement = DbHelper.setPrepareData("INSERT INTO jobs (COMPANYNAME, DATE, ENDDATE, PERSON, COMMENT, ISDONE) values(?,?,?,?,?,?)");
            preparedStatement.setString(1, job.getJobCompany());
            preparedStatement.setDate(2, (Date) job.getJobDate());
            preparedStatement.setDate(3, (Date) job.getJobEndDate());
            preparedStatement.setString(4, job.getJobPerson());
            preparedStatement.setString(5, job.getJobComment());
            preparedStatement.setBoolean(6, job.getJobIsDone());
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            DbHelper.showErrorMessage(exception);
        }
    }
    
    public ArrayList<Job> getJobs() throws SQLException {
        ArrayList<Job> jobs = null;
        try {
            resultSet = DbHelper.getData("SELECT * FROM jobs");
            jobs = new ArrayList<>();
            while(resultSet.next()){
                jobs.add(new Job(
                    resultSet.getInt("JOBID"),
                    resultSet.getString("COMPANYNAME"),
                    resultSet.getDate("DATE"),
                    resultSet.getDate("ENDDATE"),
                    resultSet.getString("PERSON"),
                    resultSet.getString("COMMENT"),
                    resultSet.getBoolean("ISDONE")
                ));
            }
        } catch (SQLException exception) {
            DbHelper.showErrorMessage(exception);
        }
        return jobs;        
    }
    
    public void JobIsDone(int jobId, Date date) throws SQLException {
        try {
            preparedStatement = DbHelper.setPrepareData("UPDATE jobs SET ENDDATE = ?, ISDONE = 1 WHERE"
                    + " JOBID = ?");
            preparedStatement.setDate(1, (Date) date);
            preparedStatement.setInt(2, jobId);
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            DbHelper.showErrorMessage(exception);
        }
    }

    public void addOffer(Offer offer) throws SQLException {
        try {            
            preparedStatement = DbHelper.setPrepareData("INSERT INTO offers (COMPANYNAME, DATE, ENDDATE, ACCEPTDATE, PERSON, COMMENT, ISDONE, ISACCEPT, ISINVOICE) values(?,?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1, offer.getOfferCompany());
            preparedStatement.setDate(2, (Date) offer.getOfferDate());
            preparedStatement.setDate(3, (Date) offer.getOfferEndDate());
            preparedStatement.setDate(4, (Date) offer.getOfferAcceptDate());
            preparedStatement.setString(5, offer.getOfferPerson());
            preparedStatement.setString(6, offer.getOfferComment());
            preparedStatement.setBoolean(7, offer.getOfferIsDone());
            preparedStatement.setBoolean(8, offer.getOfferIsAccept());
            preparedStatement.setBoolean(9, offer.getOfferIsInvoice());
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            DbHelper.showErrorMessage(exception);
        }
    }
    
    public ArrayList<Offer> getOffers() throws SQLException {
        ArrayList<Offer> offers = null;
        try {
            resultSet = DbHelper.getData("SELECT * FROM offers");
            offers = new ArrayList<>();
            while(resultSet.next()){
                offers.add(new Offer(
                    resultSet.getInt("OFFERID"),
                    resultSet.getString("COMPANYNAME"),
                    resultSet.getDate("DATE"),
                    resultSet.getDate("ENDDATE"),
                    resultSet.getDate("ACCEPTDATE"),
                    resultSet.getString("PERSON"),
                    resultSet.getString("COMMENT"),
                    resultSet.getBoolean("ISDONE"),
                    resultSet.getBoolean("ISACCEPT"),
                    resultSet.getBoolean("ISINVOICE")
                ));
            }
        } catch (SQLException exception) {
            DbHelper.showErrorMessage(exception);
        }
        
        return offers;        
    }
    
    public void OfferIsDone(int offerId, Date date) throws SQLException {
        try {
            preparedStatement = DbHelper.setPrepareData("UPDATE offers SET ENDDATE = ?, ISDONE = 1 WHERE OFFERID = ?");
            preparedStatement.setDate(1, (Date) date);
            preparedStatement.setInt(2, offerId);
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            DbHelper.showErrorMessage(exception);
        }
    }

    public void OfferIsAccept(int offerId, Date date) throws SQLException {
        try {
            preparedStatement = DbHelper.setPrepareData("UPDATE offers SET ACCEPTDATE = ?, ISACCEPT = 1 WHERE OFFERID = ?");
            preparedStatement.setDate(1, (Date) date);
            preparedStatement.setInt(2, offerId);
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            DbHelper.showErrorMessage(exception);
        }
    }
    
    public void OfferIsInvoice(int offerId) throws SQLException {
        try {
            preparedStatement = DbHelper.setPrepareData("UPDATE offers SET ISINVOICE = 1 WHERE OFFERID = ?");
            preparedStatement.setInt(1, offerId);
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            DbHelper.showErrorMessage(exception);
        }
    }
    
    public ArrayList<Base> Expand(int id, boolean toChoose) throws SQLException{
        ArrayList<Base> base = null;
        String str;
        try {
            if(toChoose){
                resultSet = DbHelper.getData("SELECT * FROM jobs WHERE JOBID = " + id);
                str = "JOBID";
            }
            else {
                resultSet = DbHelper.getData("SELECT * FROM offers WHERE OFFERID = " + id);
                str = "OFFERID";
            }
            base = new ArrayList<>();
            while(resultSet.next()){
                base.add(new Base(
                    resultSet.getInt(str),
                    resultSet.getString("COMPANYNAME"),
                    resultSet.getDate("DATE"),
                    resultSet.getDate("ENDDATE"),
                    resultSet.getString("PERSON"),
                    resultSet.getString("COMMENT"),
                    resultSet.getBoolean("ISDONE")
                ));
            }
        } catch (SQLException exception) {
            DbHelper.showErrorMessage(exception);
        }
        return base;  
    }


}

