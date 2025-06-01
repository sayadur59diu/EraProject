package com.example.SpringBootStarterDemo.model;

import lombok.Data;

@Data

public class RetailApplicationResponse {
	private String applicationId;
    private String custCode;
    private String assessmentType;
    private Integer outCode;
    private String status;
    private String message;
	public RetailApplicationResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}
	public String getCustCode() {
		return custCode;
	}
	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}
	public String getAssessmentType() {
		return assessmentType;
	}
	public void setAssessmentType(String assessmentType) {
		this.assessmentType = assessmentType;
	}
	public Integer getOutCode() {
		return outCode;
	}
	public void setOutCode(Integer outCode) {
		this.outCode = outCode;
	}
	

    // Getters
    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    // Setters
    public void setStatus(String status) {
        this.status = status;
    }
    
 // Setters
    public void setMessage(String status) {
        this.status = message;
    }
    
    
    
    
}
