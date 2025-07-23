package com.example.rabbitmqdemo.service;

import com.example.rabbitmqdemo.model.StatementRequest;
import com.example.rabbitmqdemo.repository.StatementRepository;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.Map;

@Service
public class StatementConsumer {

    private final StatementRepository repository;

    public StatementConsumer(StatementRepository repository) {
        this.repository = repository;
    }

    @RabbitListener(queues = "statement.request.queue")
    public void generateStatement(StatementRequest request) {
        List<Map<String, Object>> data = repository.getStatementData(request.getActype(), request.getBrancd());

        new File("pdf-output").mkdir(); // Create folder if not exists

        for (Map<String, Object> row : data) {
            try (PDDocument document = new PDDocument()) {
                PDPage page = new PDPage();
                document.addPage(page);

                PDPageContentStream content = new PDPageContentStream(document, page);
                content.setFont(PDType1Font.HELVETICA_BOLD, 14);
                content.beginText();
                content.setLeading(18f);
                content.newLineAtOffset(50, 700);

                content.showText("Account Statement");
                content.newLine();
                content.showText("ACTYPE: " + row.get("ACTYPE"));
                content.newLine();
                content.showText("BRANCD: " + row.get("BRANCD"));
                content.newLine();
                content.showText("ACTNUM: " + row.get("ACTNUM"));
                content.newLine();
                content.showText("ACTTIT: " + row.get("ACTTIT"));
                content.newLine();

                content.endText();
                content.close();

                // Dynamic filename
                String actype = row.get("ACTYPE").toString();
                String brancd = row.get("BRANCD").toString();
                String actnum = row.get("ACTNUM").toString();

                String fileName = String.format("pdf-output/AccountStatement_%s_%s_%s.pdf", actype, brancd, actnum);
                document.save(fileName);
                System.out.println("PDF saved: " + fileName);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}