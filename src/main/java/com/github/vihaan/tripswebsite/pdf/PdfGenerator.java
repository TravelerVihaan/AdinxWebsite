package com.github.vihaan.tripswebsite.pdf;

import com.github.vihaan.tripswebsite.logging.LoggerSingleton;
import javassist.compiler.ast.Pair;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
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

    private final PDDocument document;
    private PDPage page;
    PDFont font;
    private Map<String, PDFont> fonts;
    PDRectangle mediaBox;

    public PdfGenerator(){
        document = new PDDocument();
        page = new PDPage(PDRectangle.A4);
        document.addPage(page);
        fonts = initializeFonts(document);
        mediaBox = page.getMediaBox();
    }

    @Override
    public PDDocument generate(){
        genrateText(MONTSERRAT_FONT, 12, IFileConstants.TOP_TEXT);
        return document;
    }

    private float[] calculateCenterOfDocument(String inputText) throws IOException {
        int marginTop = 30;
        int fontSize = 16;
        float titleWidth = font.getStringWidth(inputText) / 1000 * fontSize;
        float titleHeight = font.getFontDescriptor().getFontBoundingBox().getHeight() / 1000 * fontSize;
        float startX = (mediaBox.getWidth() - titleWidth) / 2;
        float startY = mediaBox.getHeight() - marginTop - titleHeight;
        return new float[]{startX, startY};

    }

    private PDPageContentStream genrateText(String fontType, int fontSize, String inputText){
        PDPageContentStream contentStream = null;
        try{
            contentStream = new PDPageContentStream(document, page);
            float[] dimensions = calculateCenterOfDocument(inputText);
            contentStream.beginText();
            contentStream.setFont(fonts.get(fontType), fontSize);
            contentStream.newLineAtOffset(dimensions[0],dimensions[1]);
            contentStream.showText(inputText);
            contentStream.endText();
            contentStream.close();
            document.save("/tmp/voucher-file.pdf"); // TODO
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
