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
public class Offer extends Base{
    
    private final Date offerAcceptDate; 
    private final Boolean offerIsAccept;
    private final Boolean offerIsInvoice;

    Offer(int ID, String offerCompany, Date offerDate, Date offerEndDate, Date offerAcceptDate, String offerPerson, String offerComment, Boolean offerIsDone, Boolean offerIsAccept, Boolean offerIsInvoice) {
        this.ID = ID;
        company = offerCompany;
        date = offerDate;
        endDate = offerEndDate;
        this.offerAcceptDate = offerAcceptDate;
        person = offerPerson;
        comment = offerComment;
        isDone = offerIsDone;
        this.offerIsAccept = offerIsAccept;
        this.offerIsInvoice = offerIsInvoice;
    }

    Offer(String offerCompany, Date offerDate, Date offerEndDate, Date offerAcceptDate, String offerPerson, String offerComment, Boolean offerIsDone, Boolean offerIsAccept, Boolean offerIsInvoice) {
        company = offerCompany;
        date = offerDate;
        endDate = offerEndDate;
        this.offerAcceptDate  = offerAcceptDate;
        person = offerPerson;
        comment = offerComment;
        isDone = offerIsDone;
        this.offerIsAccept = offerIsAccept;
        this.offerIsInvoice = offerIsInvoice;
    }
    
    @Override
    public int getID() {
        return ID;
    }

    public String getOfferCompany() {
        return company;
    }

    public Date getOfferDate() {
        return date;
    }

    public Date getOfferEndDate() {
        return endDate;
    }

    public Date getOfferAcceptDate() {
        return offerAcceptDate;
    }

    public String getOfferPerson() {
        return person;
    }

    public String getOfferComment() {
        return comment;
    }

    public Boolean getOfferIsDone() {
        return isDone;
    }

    public Boolean getOfferIsAccept() {
        return offerIsAccept;
    }   

    public Boolean getOfferIsInvoice() {
        return offerIsInvoice;
    }
    
}
