package com.example.SpringBootStarterDemo.model;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity

@Table(name="Apllication_temp")
public class RetailApplicationRequest {
	
	@Id
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
	private String compCode;
    private String userId;
    private String sessionId;
    private String existingCustFlg;
    private String applyDate;
    private String accountNo;
    private String custCode;
    private String custType;
    private String marketOfficer;
    private String relManager;
    private String branchCode;
    private String accountName;
    private String custCategory;
    private String relOfficer;
    private String agentFlg;
    private String empCategory;
    private String branchManager;
    private String proposalType;
    private String nameAlias;
    private String rmCode;
    private String altRmCode;
    private String jointAppFlg;
    private String jointCustId;
    private String subBranch;
    private String agentOutlet;
    private String priorityCenter;
    private String corpCompany;
    private String priorityStatus;
    private String priorityRemarks;
    private String leadId;
    private String assessmentType;
    private String customerCategory;
	
    public RetailApplicationRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
    
    
    public String getCompCode() {
		return compCode;
	}

	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getExistingCustFlg() {
		return existingCustFlg;
	}

	public void setExistingCustFlg(String existingCustFlg) {
		this.existingCustFlg = existingCustFlg;
	}

	public String getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getCustCode() {
		return custCode;
	}

	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}

	public String getCustType() {
		return custType;
	}

	public void setCustType(String custType) {
		this.custType = custType;
	}

	public String getMarketOfficer() {
		return marketOfficer;
	}

	public void setMarketOfficer(String marketOfficer) {
		this.marketOfficer = marketOfficer;
	}

	public String getRelManager() {
		return relManager;
	}

	public void setRelManager(String relManager) {
		this.relManager = relManager;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getCustCategory() {
		return custCategory;
	}

	public void setCustCategory(String custCategory) {
		this.custCategory = custCategory;
	}

	public String getRelOfficer() {
		return relOfficer;
	}

	public void setRelOfficer(String relOfficer) {
		this.relOfficer = relOfficer;
	}

	public String getAgentFlg() {
		return agentFlg;
	}

	public void setAgentFlg(String agentFlg) {
		this.agentFlg = agentFlg;
	}

	public String getEmpCategory() {
		return empCategory;
	}

	public void setEmpCategory(String empCategory) {
		this.empCategory = empCategory;
	}

	public String getBranchManager() {
		return branchManager;
	}

	public void setBranchManager(String branchManager) {
		this.branchManager = branchManager;
	}

	public String getProposalType() {
		return proposalType;
	}

	public void setProposalType(String proposalType) {
		this.proposalType = proposalType;
	}

	public String getNameAlias() {
		return nameAlias;
	}

	public void setNameAlias(String nameAlias) {
		this.nameAlias = nameAlias;
	}

	public String getRmCode() {
		return rmCode;
	}

	public void setRmCode(String rmCode) {
		this.rmCode = rmCode;
	}

	public String getAltRmCode() {
		return altRmCode;
	}

	public void setAltRmCode(String altRmCode) {
		this.altRmCode = altRmCode;
	}

	public String getJointAppFlg() {
		return jointAppFlg;
	}

	public void setJointAppFlg(String jointAppFlg) {
		this.jointAppFlg = jointAppFlg;
	}

	public String getJointCustId() {
		return jointCustId;
	}

	public void setJointCustId(String jointCustId) {
		this.jointCustId = jointCustId;
	}

	public String getSubBranch() {
		return subBranch;
	}

	public void setSubBranch(String subBranch) {
		this.subBranch = subBranch;
	}

	public String getAgentOutlet() {
		return agentOutlet;
	}

	public void setAgentOutlet(String agentOutlet) {
		this.agentOutlet = agentOutlet;
	}

	public String getPriorityCenter() {
		return priorityCenter;
	}

	public void setPriorityCenter(String priorityCenter) {
		this.priorityCenter = priorityCenter;
	}

	public String getCorpCompany() {
		return corpCompany;
	}

	public void setCorpCompany(String corpCompany) {
		this.corpCompany = corpCompany;
	}

	public String getPriorityStatus() {
		return priorityStatus;
	}

	public void setPriorityStatus(String priorityStatus) {
		this.priorityStatus = priorityStatus;
	}

	public String getPriorityRemarks() {
		return priorityRemarks;
	}

	public void setPriorityRemarks(String priorityRemarks) {
		this.priorityRemarks = priorityRemarks;
	}

	public String getLeadId() {
		return leadId;
	}

	public void setLeadId(String leadId) {
		this.leadId = leadId;
	}

	public String getAssessmentType() {
		return assessmentType;
	}

	public void setAssessmentType(String assessmentType) {
		this.assessmentType = assessmentType;
	}

	public String getCustomerCategory() {
		return customerCategory;
	}

	public void setCustomerCategory(String customerCategory) {
		this.customerCategory = customerCategory;
	}
    
    
    
    
}
