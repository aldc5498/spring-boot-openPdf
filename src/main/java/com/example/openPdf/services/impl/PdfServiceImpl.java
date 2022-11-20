package com.example.openPdf.services.impl;

import com.example.openPdf.services.PdfService;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

@Service
public class PdfServiceImpl implements PdfService {

    private Logger log = LoggerFactory.getLogger(PdfServiceImpl.class);

    @Override
    public ByteArrayInputStream createPdf(String title, String content) {

        log.info("Create pdf started : ");

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Document document = new Document();

        PdfWriter.getInstance(document, out);

        document.open();

        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20);
        Paragraph titlePara = new Paragraph(title, titleFont);

        titlePara.setAlignment(Element.ALIGN_CENTER);
        document.add(titlePara);

        Font paraFont = FontFactory.getFont(FontFactory.HELVETICA, 17);
        Paragraph paragraph = new Paragraph(content, paraFont);
//        paragraph.add(new Chunk("Wow this is the chunk paragraph"));
        document.add(paragraph);

        document.close();

        return new ByteArrayInputStream(out.toByteArray());

    }
}
