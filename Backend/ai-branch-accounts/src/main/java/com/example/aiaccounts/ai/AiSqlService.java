package com.example.aiaccounts.ai;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AiSqlService {
    private final ChatClient chatClient;
    private final JdbcTemplate jdbcTemplate;

    private static final String SCHEMA_PROMPT = """
        You are a senior SQL analyst. Given a user question, output ONLY a valid Oracle SQL SELECT statement.
        Rules:
        - READ-ONLY: SELECT statements only. No DML/DDL.
        - LIMIT scope to these tables/columns:
          - stfacmas(account_no, branch_code, customer_name, product_code, open_date, status, current_balance)
          - stfetran(id, account_no, branch_code, tran_date, tran_type, amount, narrative)
        - Use ANSI joins. Prefer grouping where needed.
        - For outstanding, compute SUM(CASE WHEN tran_type='DR' THEN amount ELSE -amount END) as OUTSTANDING.
        - Return at most 200 rows (append "FETCH FIRST 200 ROWS ONLY").
        - NEVER reference tables not listed.
        - Do NOT include semicolons at the end.
        Output only the SQL, nothing else.
        """;

    @Transactional(readOnly = true)
    public Map<String, Object> answer(String question) {
        // 1. Generate SQL
        String sql = chatClient.prompt()
                .user(SCHEMA_PROMPT + "\nQuestion: " + question)
                .call()
                .content()
                .replace(";", ""); // remove any semicolon

        // 2. Safety filter
        String upper = sql.toUpperCase();
        if (!upper.startsWith("SELECT") || upper.matches(".*\\b(INSERT|UPDATE|DELETE|MERGE|ALTER|DROP|CREATE|GRANT|BEGIN)\\b.*")) {
            return Map.of("error", "Unsafe or invalid SQL rejected.");
        }

        // 3. Execute query
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

        // 4. Build response
        if (rows.isEmpty()) {
            return Map.of("sql", sql, "rows", rows, "message", "No results found.");
        }

        return Map.of("sql", sql, "rows", rows);
    }
}