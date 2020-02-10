package com.github.vihaan.tripswebsite.pdf;

import com.github.vihaan.tripswebsite.logging.LoggerSingleton;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

@Service
@Qualifier("pdfItextGenerator")
public class PdfItextGenerator implements FileGenerator<Document>{

    @Override
    public void generate() throws IOException {
        Document document = new Document(PageSize.A4,20, 20, 20, 20);
        try {
            PdfWriter.getInstance(document, new FileOutputStream(IFileConstants.TMP_FILE_PATH));

        registerFonts();
        document.open();
        addNewLine(document);
        document.add(new Chunk(IFileConstants.TOP_TEXT, prepareFont(IFileConstants.MONTSERRAT_FONT, 10)));
        addNewLine(document);
        document.add(new Chunk(IFileConstants.TRIP_NAME, prepareFont(IFileConstants.LIBRE_FONT, 20)));
        addNewLines(document,4);
        document.add(new Chunk(IFileConstants.BOOKING_TEXT, prepareFont(IFileConstants.OPENSANS_FONT,14)));
        addNewLine(document);


        }catch(DocumentException e){
            LoggerSingleton.getLogger(this.getClass()).warn(e.getMessage());
        }
    }

    private Font prepareFont(String fontType, int fontSize){
        return prepareFont(fontType, fontSize, BaseColor.BLACK);
    }

    private Font prepareFont(String fontType, int fontSize, BaseColor color){
        return FontFactory.getFont(fontType, fontSize, color);
    }

    private void registerFonts(){
        FontFactory.register(IFileConstants.OPENSANS_FONT_PATH,IFileConstants.OPENSANS_FONT);
        FontFactory.register(IFileConstants.MONTSERRAT_FONT_PATH,IFileConstants.MONTSERRAT_FONT);
        FontFactory.register(IFileConstants.LIBRE_FONT_PATH,IFileConstants.LIBRE_FONT);
    }

    private void addNewLine(Document document) throws DocumentException {
        document.add(Chunk.NEWLINE);
    }

    private void addNewLines(Document document, int count) throws DocumentException {
        for(int i=0;i<count;i++){
            addNewLine(document);
        }
    }

    private void addStartTripDetails(Document document){

    }

    private void addOrderDetails(Document document){

    }

    private void addPaymentDetails(Document document){

    }
}
