package com.github.vihaan.tripswebsite.trips;

import com.github.vihaan.tripswebsite.httpstatus.HttpStatusEnum;
import com.github.vihaan.tripswebsite.pdf.FileGenerator;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class TripBookingProcessor {

    private final FileGenerator<Document> fileGenerator;
    private final TripBooker tripBooker;

    @Autowired
    public TripBookingProcessor(@Qualifier("pdfItextGenerator")FileGenerator<Document> pdfItextGenerator,
                                TripBooker tripBooker) {
        this.fileGenerator = pdfItextGenerator;
        this.tripBooker = tripBooker;
    }

    // TODO ???
    HttpStatusEnum processTripBooking(TripDTO tripDTO) {
        List<String> errors = tripBooker.executeBooking(tripDTO);
        if(errors.isEmpty()){
            try {
                fileGenerator.generate(tripDTO);
                return HttpStatusEnum.CREATED;
            } catch (IOException | DocumentException ioe) {
                LOGGER.warn(ioe.getMessage());
                return HttpStatusEnum.CONFLICT;
            }
        }
        return HttpStatusEnum.CONFLICT;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(TripBookingProcessor.class);
}
