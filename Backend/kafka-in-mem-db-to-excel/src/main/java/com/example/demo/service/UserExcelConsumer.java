package com.example.demo.service;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.example.demo.entity.AppUser;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class UserExcelConsumer {

    private final List<AppUser> userBuffer = new ArrayList<>();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "h2-users", groupId = "h2-to-excel")
    public void consume(String message) throws Exception {
        AppUser user = objectMapper.readValue(message, AppUser.class);
        userBuffer.add(user);

        if (userBuffer.size() >= 5) {
            writeUsersToExcel(userBuffer);
            userBuffer.clear();
        }
    }

    private void writeUsersToExcel(List<AppUser> users) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Users");

            // Header
            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("ID");
            header.createCell(1).setCellValue("Name");
            header.createCell(2).setCellValue("Email");

            // Rows
            int rowNum = 1;
            for (AppUser user : users) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(user.getId());
                row.createCell(1).setCellValue(user.getName());
                row.createCell(2).setCellValue(user.getEmail());
            }

            // Write file
            String filename = "users_" + System.currentTimeMillis() + ".xlsx";
            try (FileOutputStream fileOut = new FileOutputStream(filename)) {
                workbook.write(fileOut);
                System.out.println("Excel exported: " + filename);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
