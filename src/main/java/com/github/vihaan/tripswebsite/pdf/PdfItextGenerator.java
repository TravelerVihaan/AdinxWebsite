package com.github.vihaan.tripswebsite.pdf;

import com.github.vihaan.tripswebsite.logging.LoggerSingleton;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;

@Service
@Qualifier("pdfItextGenerator")
public class PdfItextGenerator implements FileGenerator<Document>{

    @Override
    public Document generate() throws IOException {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("/tmp/voucher.pdf"));
        }catch(DocumentException e){
            LoggerSingleton.getLogger(this.getClass()).warn(e.getMessage());
        }
        Chunk chunk = new Chunk("Hello World", font);
        document.open();
    }

    private Font prepareFont(String fontType, String fontSize){

    }
}
