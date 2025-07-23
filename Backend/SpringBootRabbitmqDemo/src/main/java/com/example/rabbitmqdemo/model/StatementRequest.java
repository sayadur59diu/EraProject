package com.example.rabbitmqdemo.model;
import java.io.Serializable;

public class StatementRequest implements Serializable {

    private String actype;
    private String brancd;
   // private String accountId;
    //private String fromDate;
    //private String toDate;

    // Getters and Setters
    public String getActype() {
        return actype;
    }

    public void setActype(String actype) {
        this.actype = actype;
    }

    public String getBrancd() {
        return brancd;
    }

    public void setBrancd(String brancd) {
        this.brancd = brancd;
    }


}