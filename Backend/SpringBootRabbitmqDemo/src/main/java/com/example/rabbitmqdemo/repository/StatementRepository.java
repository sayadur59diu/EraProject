package com.example.rabbitmqdemo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class StatementRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> getStatementData(String actype, String brancd) {
        String sql = """
                    SELECT BRANCD, ACTYPE, ACTNUM, ACTTIT
                    FROM stlbas.STFACMAS
                    WHERE ACTYPE = ? AND BRANCD = ? AND ACSTAT = 'ACT'
                    """;

        return jdbcTemplate.queryForList(sql, actype, brancd);
    }
}