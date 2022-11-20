package com.example.openPdf.controller;

import com.example.openPdf.services.PdfService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.ByteArrayInputStream;

@Controller
@RequestMapping("/api/pdf")
@RequiredArgsConstructor
public class PdfController {

    private final PdfService pdfService;

    @GetMapping("/create-pdf/{title}/{content}")
    public ResponseEntity<InputStreamResource> createPdf(@PathVariable String title, @PathVariable String content) {
        ByteArrayInputStream pdf = this.pdfService.createPdf(title, content);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Disposition", "inline;file=lcwd.pdf");
        return ResponseEntity
            .ok()
            .headers(httpHeaders)
            .contentType(MediaType.APPLICATION_PDF)
            .body(new InputStreamResource(pdf));
    }


}
