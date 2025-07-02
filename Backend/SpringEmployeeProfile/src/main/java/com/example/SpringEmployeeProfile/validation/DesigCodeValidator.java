    package com.example.SpringEmployeeProfile.validation;

    import jakarta.validation.ConstraintValidator;
    import jakarta.validation.ConstraintValidatorContext;
    import lombok.extern.slf4j.Slf4j;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Component;

    import javax.sql.DataSource;
    import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;

    @Component
    @Slf4j
    public class DesigCodeValidator implements ConstraintValidator<ValidDesigCode, String> {

        @Autowired
        private DataSource dataSource;  // Field Injection


        @Override
        public void initialize(ValidDesigCode constraintAnnotation) {
            // Any initialization if required
        }

        @Override
        public boolean isValid(String desigCode, ConstraintValidatorContext context) {
            if (desigCode == null || desigCode.trim().isEmpty()) {
                return true; // Not your validator’s responsibility
            }

            if (dataSource == null) {
                log.error("DataSource is null! Validator injection failed.");
                System.out.println("DataSource is null! Validator injection failed.");
                return false;
            }

            try (Connection connection = dataSource.getConnection();
                 PreparedStatement ps = connection.prepareStatement("SELECT COUNT(*) FROM hrm_designation WHERE desig_code = '002'"))
            {
                //ps.setString(1, desigCode);
                ResultSet rs = ps.executeQuery();
                if (rs == null) {
                    log.error("ResultSet is null! Query execution failed.");
                    System.out.println("ResultSet is null! Query execution failed.");
                    return false;
                }
                try {
                    String st="result Set: "+rs.getStatement();
                    log.info(st);
                }
                catch (Exception e) {
                    log.error("Error retrieving ResultSet metadata: {}", e.getMessage());
                }

                if (rs.next()) {
                    log.info("Checking designation code: {}, exists: {}", desigCode, rs.getInt(1) > 0);
                    return rs.getInt(1) > 0;
                }

            } catch (Exception e)
            {
                log.error("Error validating designation code: {}, {}, {}", desigCode, e.getMessage(), e);
                return false;
            }

            return false;
        }
    }