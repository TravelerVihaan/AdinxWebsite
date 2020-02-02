package com.github.vihaan.tripswebsite.pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("pdfGenerator")
public class PdfGenerator implements FileGenerator<PDDocument>{
    @Override
    public PDDocument generate() {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        return document;
    }
}
