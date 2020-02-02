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

    PDDocument document;
    PDPage page;
    private Map<String, PDFont> fonts;

    public PdfGenerator(){
        document = new PDDocument();
        page = new PDPage();
        document.addPage(page);
        fonts = initializeFonts(document);
    }

    @Override
    public PDDocument generate(){

        return document;
    }

    private PDPageContentStream genrateText(String fontType, int fontSize){
        PDPageContentStream contentStream = null;
        try{
            contentStream = new PDPageContentStream(document, page);
            contentStream.setFont(fonts.get(fontType), fontSize);
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
            fonts.put(LIBRE_FONT, PDTrueTypeFont.loadTTF(document, new File(LIBRE_FONT_PATH)));
            fonts.put(MONTSERRAT_FONT, PDTrueTypeFont.loadTTF(document, new File(MONTSERRAT_FONT_PATH)));
            fonts.put(OPENSANS_FONT, PDTrueTypeFont.loadTTF(document, new File(OPENSANS_FONT_PATH)));
        }catch(IOException e){
            LoggerSingleton.getLogger(this.getClass()).warn(e.getMessage());
        }
        return fonts;
    }

    // PDF Fonts
    private final String LIBRE_FONT = "Libre";
    private final String LIBRE_FONT_PATH = "src/main/resources/fonts/LibreBaskerville-Regular.ttf";
    private final String MONTSERRAT_FONT = "Montserrat";
    private final String MONTSERRAT_FONT_PATH = "src/main/resources/fonts/Montserrat-Bold.ttf";
    private final String OPENSANS_FONT = "OpenSans";
    private final String OPENSANS_FONT_PATH = "src/main/resources/fonts/OpenSans-Light.ttf";
}
