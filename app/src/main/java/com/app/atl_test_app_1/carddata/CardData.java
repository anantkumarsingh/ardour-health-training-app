package com.app.atl_test_app_1.carddata;

public class CardData {

    private String docName;
    private String docSpecialty;
    private String aptDate;
    private String aptTime;



    public CardData(String docName, String docSpecialty, String aptDate, String aptTime) {
        this.docName = docName;
        this.docSpecialty = docSpecialty;
        this.aptDate = aptDate;
        this.aptTime = aptTime;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String noteTitle) {
        this.docName = docName;
    }

    public String getDocSpec() {
        return docSpecialty;
    }

    public void setDocSpecialty(String docSpecialty) {
        this.docSpecialty = docSpecialty;
    }


    public String getAptDate() {
        return aptDate;
    }

    public void setAptDate(String aptDate) {
        this.aptDate = aptDate;
    }

    public String getAptTime() {
        return aptTime;
    }

    public void setAptTime(String aptTime) {
        this.aptTime = aptTime;
    }



}






