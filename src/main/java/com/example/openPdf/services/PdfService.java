package com.example.openPdf.services;

import java.io.ByteArrayInputStream;

public interface PdfService {

    ByteArrayInputStream createPdf(String title, String content);

}
