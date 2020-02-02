package com.github.vihaan.tripswebsite.pdf;

import com.itextpdf.text.pdf.PdfDocument;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Qualifier("pdfItextGenerator")
public class PdfItextGenerator implements FileGenerator<PdfDocument>{

    @Override
    public PdfDocument generate() throws IOException {
        return null;
    }
}
