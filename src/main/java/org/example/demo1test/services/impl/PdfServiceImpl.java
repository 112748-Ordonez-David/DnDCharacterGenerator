package org.example.demo1test.services.impl;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.example.demo1test.services.PdfService;
import org.springframework.stereotype.Service;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class PdfServiceImpl implements PdfService {


    @Override
    public byte[] generatePdf() {

//        try (PDDocument document = new PDDocument()) {
//            PDPage page = new PDPage(PDRectangle.A4);
//            document.addPage(page);
//
//            PDPageContentStream contentStream = new PDPageContentStream(document, page);
//
//            // Agregar texto al PDF
//            contentStream.beginText();
//            contentStream.setFont(PDType1Font.HELVETICA, 12);
//            contentStream.newLineAtOffset(100, 700); // Posición en la página
//            contentStream.showText("Este es un PDF generado con Apache PDFBox.");
//            contentStream.endText();
//
//            // Agregar imagen al PDF
//            //String imagePath = "ruta/de/tu/imagen.png"; // Ruta a la imagen
//           // PDImageXObject image = PDImageXObject.createFromFile(imagePath, document);
//           // contentStream.drawImage(image, 100, 500, 200, 200); // Posición y tamaño de la imagen
//
//            contentStream.close();
//
//            // Convertir el documento a un array de bytes
//            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//            document.save(byteArrayOutputStream);
//            return byteArrayOutputStream.toByteArray();
//
//
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }



        // Stream para agregar contenido
        try {
            // Crear un documento nuevo
            PDDocument document = new PDDocument();
            PDPage page = new PDPage();
            document.addPage(page);

            // Stream para agregar contenido
            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            // Encabezado: Nombre de la empresa
            contentStream.beginText();
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 20);
            contentStream.newLineAtOffset(50, 750);
            contentStream.showText("Empresa Ejemplo S.A.");
            contentStream.endText();

            // Información del cliente
            contentStream.beginText();
            contentStream.setFont(PDType1Font.HELVETICA, 12);
            contentStream.newLineAtOffset(50, 700);
            contentStream.showText("Cliente: Juan Pérez");
            contentStream.newLineAtOffset(0, -15);
            contentStream.showText("Dirección: Calle Falsa 123, Ciudad");
            contentStream.newLineAtOffset(0, -15);
            contentStream.showText("Fecha: 21/09/2024");
            contentStream.endText();

            // Detalles de productos o servicios
            float startY = 650;
            String[][] items = {
                    {"Producto 1", "2", "$15.99", "$31.98"},
                    {"Producto 2", "1", "$25.50", "$25.50"},
                    {"Producto 3", "3", "$10.00", "$30.00"}
            };

            // Encabezados de la tabla
            contentStream.beginText();
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
            contentStream.newLineAtOffset(50, startY);
            contentStream.showText("Descripción       Cantidad       Precio Unitario       Subtotal");
            contentStream.endText();

            // Contenido de la tabla
            startY -= 20;
            for (String[] item : items) {
                contentStream.beginText();
                contentStream.setFont(PDType1Font.HELVETICA, 12);
                contentStream.newLineAtOffset(50, startY);
                contentStream.showText(item[0] + "         " + item[1] + "                 " + item[2] + "                 " + item[3]);
                contentStream.endText();
                startY -= 15;
            }

            // Total
            contentStream.beginText();
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
            contentStream.newLineAtOffset(50, startY - 30);
            contentStream.showText("Total: $87.48");
            contentStream.endText();

            // Finaliza el contenido y guarda el PDF en un stream
            contentStream.close();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            document.save(byteArrayOutputStream);
            document.close();

            // Retorna el PDF como byte array
            return byteArrayOutputStream.toByteArray();



        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }



}
