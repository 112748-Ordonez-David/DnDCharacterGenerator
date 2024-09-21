package org.example.demo1test.services.impl;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.example.demo1test.services.PdfService;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class PdfServiceImpl implements PdfService {


    @Override
    public byte[] generatePdf() {

        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            // Agregar texto al PDF
            contentStream.beginText();
            contentStream.setFont(PDType1Font.HELVETICA, 12);
            contentStream.newLineAtOffset(100, 700); // Posición en la página
            contentStream.showText("Este es un PDF generado con Apache PDFBox.");
            contentStream.endText();

            // Agregar imagen al PDF
            //String imagePath = "ruta/de/tu/imagen.png"; // Ruta a la imagen
           // PDImageXObject image = PDImageXObject.createFromFile(imagePath, document);
           // contentStream.drawImage(image, 100, 500, 200, 200); // Posición y tamaño de la imagen

            contentStream.close();

            // Convertir el documento a un array de bytes
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            document.save(byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }



}
