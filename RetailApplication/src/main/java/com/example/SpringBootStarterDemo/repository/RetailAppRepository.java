package com.example.SpringBootStarterDemo.repository;

import org.springframework.stereotype.Repository;

import com.example.SpringBootStarterDemo.model.RetailApplicationRequest;
import com.example.SpringBootStarterDemo.model.RetailApplicationResponse;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;

@Repository
public class RetailAppRepository {
	@PersistenceContext
    private EntityManager entityManager;

    public RetailApplicationResponse callRetailProcedure(RetailApplicationRequest request) {
        RetailApplicationResponse response = new RetailApplicationResponse();

        try {
            StoredProcedureQuery query = entityManager
                    .createStoredProcedureQuery("dpr_oca_gen_retail_app_id")
                    .registerStoredProcedureParameter("in_comp_code", String.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("in_userid", String.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("in_sessionid", String.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("in_existing_cust_flg", String.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("in_apply_date", String.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("in_account_no", String.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("in_cust_code", String.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("in_cust_type", String.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("in_market_officer", String.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("in_rel_manager", String.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("in_branch_code", String.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("in_account_name", String.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("in_cust_category", String.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("in_rel_officer", String.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("in_agent_flg", String.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("in_emp_category", String.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("in_branch_manager", String.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("in_proposal_type", String.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("in_name_alias", String.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("in_rm_code", String.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("in_alt_rm_code", String.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("in_joint_app_flg", String.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("in_joint_cust_id", String.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("in_Sub_Branch", String.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("in_Agent_Outlet", String.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("in_Priority_center", String.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("in_corp_company", String.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("in_priority_status", String.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("in_priority_remarks", String.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("in_lead_id", String.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("in_assessment_type", String.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("in_customer_category", String.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("out_application_id", String.class, ParameterMode.OUT)
                    .registerStoredProcedureParameter("out_cust_code", String.class, ParameterMode.OUT)
                    .registerStoredProcedureParameter("out_assessment_type", String.class, ParameterMode.OUT)
                    .registerStoredProcedureParameter("out_code", Integer.class, ParameterMode.OUT);

            // Set parameters
            query.setParameter("in_comp_code", request.getCompCode());
            query.setParameter("in_userid", request.getUserId());
            query.setParameter("in_sessionid", request.getSessionId());
            query.setParameter("in_existing_cust_flg", request.getExistingCustFlg());
            query.setParameter("in_apply_date", request.getApplyDate());
            query.setParameter("in_account_no", request.getAccountNo());
            query.setParameter("in_cust_code", request.getCustCode());
            query.setParameter("in_cust_type", request.getCustType());
            query.setParameter("in_market_officer", request.getMarketOfficer());
            query.setParameter("in_rel_manager", request.getRelManager());
            query.setParameter("in_branch_code", request.getBranchCode());
            query.setParameter("in_account_name", request.getAccountName());
            query.setParameter("in_cust_category", request.getCustCategory());
            query.setParameter("in_rel_officer", request.getRelOfficer());
            query.setParameter("in_agent_flg", request.getAgentFlg());
            query.setParameter("in_emp_category", request.getEmpCategory());
            query.setParameter("in_branch_manager", request.getBranchManager());
            query.setParameter("in_proposal_type", request.getProposalType());
            query.setParameter("in_name_alias", request.getNameAlias());
            query.setParameter("in_rm_code", request.getRmCode());
            query.setParameter("in_alt_rm_code", request.getAltRmCode());
            query.setParameter("in_joint_app_flg", request.getJointAppFlg());
            query.setParameter("in_joint_cust_id", request.getJointCustId());
            query.setParameter("in_Sub_Branch", request.getSubBranch());
            query.setParameter("in_Agent_Outlet", request.getAgentOutlet());
            query.setParameter("in_Priority_center", request.getPriorityCenter());
            query.setParameter("in_corp_company", request.getCorpCompany());
            query.setParameter("in_priority_status", request.getPriorityStatus());
            query.setParameter("in_priority_remarks", request.getPriorityRemarks());
            query.setParameter("in_lead_id", request.getLeadId());
            query.setParameter("in_assessment_type", request.getAssessmentType());
            query.setParameter("in_customer_category", request.getCustomerCategory());

            // Execute
            query.execute();

            // Collect output
            response.setApplicationId((String) query.getOutputParameterValue("out_application_id"));
            response.setCustCode((String) query.getOutputParameterValue("out_cust_code"));
            response.setAssessmentType((String) query.getOutputParameterValue("out_assessment_type"));
            response.setOutCode((Integer) query.getOutputParameterValue("out_code"));

        } catch (Exception e) {
            // Log the error
            e.printStackTrace();  // Replace with logger in real-world use
            response.setStatus("ERROR");
            response.setMessage("Stored procedure execution failed: " + e.getMessage());
        }

        return response;
    }
}