package com.github.vihaan.tripswebsite.pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Qualifier("pdfGenerator")
public class PdfGenerator implements FileGenerator<PDDocument>{
    @Override
    public PDDocument generate() throws IOException {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        PDPageContentStream contentStream = new PDPageContentStream(document, page);

        return document;
    }

    private PDPageContentStream generatePdfContent(){

    }
}
