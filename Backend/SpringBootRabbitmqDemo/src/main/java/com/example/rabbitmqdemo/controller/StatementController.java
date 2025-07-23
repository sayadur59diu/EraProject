package com.example.rabbitmqdemo.controller;

import com.example.rabbitmqdemo.model.StatementRequest;
import com.example.rabbitmqdemo.service.StatementProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.io.File;

@RestController
@RequestMapping("/api/statements")
public class StatementController {

    @Autowired
    private  StatementProducer producer;



    @PostMapping("/request")
    public String requestStatement(@RequestBody StatementRequest request) {
        producer.requestStatement(request);
        return "Statement request sent for Account Type: " + request.getActype() +
                ", Branch Code: " + request.getBrancd();
    }

    @GetMapping("/{acType}/{branCd}/{accountId}")
    public ResponseEntity<Resource> downloadStatement(@PathVariable String acType,
                                                      @PathVariable String branCd,
                                                      @PathVariable String accountId) {
        File file = new File("pdf-output/AccountStatement_" + acType + "_" + branCd + "_" + accountId + ".pdf");

        if (!file.exists()) {
            return ResponseEntity.notFound().build();
        }

        FileSystemResource resource = new FileSystemResource(file);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(ContentDisposition.inline().filename(file.getName()).build());

        return ResponseEntity.ok()
                .headers(headers)
                .body(resource);
    }
}