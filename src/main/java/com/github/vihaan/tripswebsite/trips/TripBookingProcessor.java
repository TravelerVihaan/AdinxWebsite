package com.github.vihaan.tripswebsite.trips;

import com.github.vihaan.tripswebsite.httpstatus.HttpStatusEnum;
import com.github.vihaan.tripswebsite.logging.LoggerSingleton;
import com.github.vihaan.tripswebsite.pdf.FileGenerator;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class TripBookingProcessor {

    private final FileGenerator<Document> fileGenerator;
    private final TripBooking tripBooking;

    @Autowired
    public TripBookingProcessor(@Qualifier("pdfItextGenerator")FileGenerator<Document> pdfItextGenerator,
                                TripBooking tripBooking) {
        this.fileGenerator = pdfItextGenerator;
        this.tripBooking = tripBooking;
    }

    // TODO ???
    HttpStatusEnum processTripBooking(TripDTO tripDTO) {
        List<String> errors = tripBooking.executeBooking(tripDTO);
        if(errors.isEmpty()){
            try {
                fileGenerator.generate(tripDTO);
                return HttpStatusEnum.CREATED;
            } catch (IOException ioe) {
                LoggerSingleton.getLogger(this.getClass()).warn(ioe.getMessage());
                return HttpStatusEnum.CONFLICT;
            } catch (DocumentException de) {
                LoggerSingleton.getLogger(this.getClass()).warn(de.getMessage());
                return HttpStatusEnum.CONFLICT;
            }
        }
        return HttpStatusEnum.CONFLICT;
    }
}
