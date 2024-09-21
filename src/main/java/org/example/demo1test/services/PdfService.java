package org.example.demo1test.services;

import org.springframework.stereotype.Service;

@Service
public interface PdfService {

    byte[] generatePdf();
}
