package com.github.vihaan.tripswebsite.pdf;

import com.github.vihaan.tripswebsite.logging.LoggerSingleton;
import com.github.vihaan.tripswebsite.trips.TripDTO;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Set;

@Service
@Qualifier("pdfItextGenerator")
public class PdfItextGenerator implements FileGenerator<Document>{

    @Override
    public Document generate(TripDTO tripDTO) throws DocumentException, IOException{

        Document document = new Document(PageSize.A4,20, 20, 20, 20);

        try{
            PdfWriter.getInstance(document, new FileOutputStream(getFileName(tripDTO)));

            registerFonts();
            document.open();
            addNewLine(document);
            // Thank you for order text
            addNewLineWithText(document,
                    IFileConstants.TOP_TEXT,
                    prepareFont(IFileConstants.MONTSERRAT_FONT, 10));
            addNewLine(document);

            // Big text with destination of trip
            addNewLineWithText(document,
                    getDestination(tripDTO).toUpperCase(),
                    prepareFont(IFileConstants.LIBRE_FONT, 20));
            addNewLines(document,4);
            // You have booked tour to ...
            addNewLineWithText(document,
                    IFileConstants.BOOKING_TEXT + getDestination(tripDTO),
                    getStandardFont());
            addNewLine(document);

            addStartTripDetails(document, tripDTO);
            addOrderDetails(document,tripDTO);
            addTicketsInfo(document,tripDTO);
            addPaymentDetails(document,tripDTO);
            addFinalizeInfo(document);
            document.addTitle("ticket"+tripDTO.getVoucherNumber()+".pdf");
        }finally{
            if(document!=null){
                document.close();
            }
        }
        return document;
    }
    private Font getStandardFont(){
        return prepareFont(IFileConstants.OPENSANS_FONT,14);
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

    private void addNewLineWithText(Document document, String text, Font font) throws DocumentException {
        document.add(new Chunk(text, font));
    }

    private void addNewLines(Document document, int count) throws DocumentException {
        for(int i=0;i<count;i++){
            addNewLine(document);
        }
    }

    private void addStartTripDetails(Document document, TripDTO tripDTO) throws DocumentException {
        // We will pick you up from ...
        addNewLineWithText(document,
                IFileConstants.PICK_TEXT +  tripDTO.getUserDTO().getFullHotelName(),
                getStandardFont());
        // Details hotel + date + hour
        addNewLineWithText(document, tripDTO.getUserDTO().getHotelAddress(), getStandardFont());
        addNewLine(document);
    }

    private void addOrderDetails(Document document, TripDTO tripDTO) throws DocumentException {
        // Here are order details
        addNewLineWithText(document, IFileConstants.DETAILS_TEXT, getStandardFont());
        // Voucher number...
        addNewLineWithText(document,
                IFileConstants.VOUCHER_NUMBER + tripDTO.getVoucherNumber(),
                getStandardFont());
        // Tour language: English
        addNewLineWithText(document,
                IFileConstants.LANGUAGE + tripDTO.getVoucherNumber(),
                getStandardFont());
        // Client's info:
        addNewLineWithText(document,
                IFileConstants.CLIENT + tripDTO.getPersonName(),
                getStandardFont());
        // Tickets info
        addTicketsInfo(document, tripDTO);
        // Price ... PLN
        addNewLineWithText(document,
                IFileConstants.PRICE1 + tripDTO.getTripCost() + IFileConstants.PRICE2,
                getStandardFont());
        addPaymentDetails(document, tripDTO);
    }

    private void addTicketsInfo(Document document, TripDTO tripDTO) throws DocumentException {
        // Tickets
        addNewLineWithText(document,
                IFileConstants.TICKETS_INFO,
                getStandardFont());
        // Specific tickets info
        if(tripDTO.getNormalTickets()>0){
            addNewLineWithText(document,
                    IFileConstants.NORMAL_TICKETS + tripDTO.getNormalTickets() + IFileConstants.TICKETS,
                    getStandardFont());
        }
        if(tripDTO.getReducedTickets()>0){
            addNewLineWithText(document,
                    IFileConstants.REDUCED_TICKETS + tripDTO.getReducedTickets() + IFileConstants.TICKETS,
                    getStandardFont());
        }
        addNewLineWithText(document, IFileConstants.PRICE1 + tripDTO.getTripCost() + IFileConstants.PRICE2, getStandardFont());
    }

    private void addPaymentDetails(Document document, TripDTO tripDTO) throws DocumentException {
        addNewLineWithText(document, IFileConstants.PAYMENT, getStandardFont());
        addNewLineWithText(document,
                IFileConstants.ORDER_DATE + tripDTO.getOrderDate().format(formatDate()),
                getStandardFont());
    }

    private void addFinalizeInfo(Document document) throws DocumentException {
        addNewLineWithText(document,IFileConstants.SIGNATURE1, getStandardFont());
        addNewLine(document);
        addNewLineWithText(document, IFileConstants.SIGNATURE2, getStandardFont());
        addNewLine(document);
    }

    private String getDestination(TripDTO dto){
        return dto.getDestination().getDestination();
    }

    private DateTimeFormatter formatDate(){
        return DateTimeFormatter.ofPattern(DATE_FORMAT_PATTERN);
    }

    private String getFileName(TripDTO tripDTO){
        return "voucher_" + tripDTO.getVoucherNumber();
    }

    String DATE_FORMAT_PATTERN = "yyyy-MM-dd HH:mm:ss";
}
