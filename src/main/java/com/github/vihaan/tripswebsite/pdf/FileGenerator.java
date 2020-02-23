package com.github.vihaan.tripswebsite.pdf;

import com.github.vihaan.tripswebsite.trips.TripDTO;
import com.itextpdf.text.DocumentException;

import java.io.IOException;

public interface FileGenerator<T> {

    T generate(TripDTO tripDTO) throws IOException, DocumentException;
}
