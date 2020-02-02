package com.github.vihaan.tripswebsite.pdf;

import com.github.vihaan.tripswebsite.logging.LoggerSingleton;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDTrueTypeFont;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
@Qualifier("pdfGenerator")
public class PdfGenerator implements FileGenerator<PDDocument>{

    @Override
    public PDDocument generate(){
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);
        Map<String, PDFont> fonts = initializeFonts(document);
        return document;
    }

    private PDPageContentStream generatePdfContent(PDDocument document, PDPage page){
        PDPageContentStream contentStream = null;
        try{
            contentStream = new PDPageContentStream(document, page);
            contentStream.setFont();
            contentStream.showText("Hello World");
            contentStream.endText();
            contentStream.close();
        }catch(IOException e){
            LoggerSingleton.getLogger(this.getClass()).warn(e.getMessage());
        }finally{
            closeStream(contentStream);
        }
    }

    private void closeStream(Closeable closeable){
        if(closeable==null) return;
        try{
            closeable.close();
        }catch (IOException e){
            LoggerSingleton.getLogger(this.getClass()).warn(e.getMessage());
        }
    }

    private Map<String, PDFont> initializeFonts(PDDocument document) {
        Map<String, PDFont> fonts = new HashMap<>();
        try {
            fonts.put("Libre", PDTrueTypeFont.loadTTF(document, new File("src/main/resources/fonts/LibreBaskerville-Regular.ttf")));
            fonts.put("Montserrat", PDTrueTypeFont.loadTTF(document, new File("src/main/resources/fonts/Montserrat-Bold.ttf")));
            fonts.put("OpenSans", PDTrueTypeFont.loadTTF(document, new File("src/main/resources/fonts/OpenSans-Light.ttf")));
        }catch(IOException e){
            LoggerSingleton.getLogger(this.getClass()).warn(e.getMessage());
        }
        return fonts;
    }
}
