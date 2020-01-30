package com.github.vihaan.tripswebsite.pdf;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("pdfGenerator")
public class PdfGenerator implements FileGenerator<Object>{
    @Override
    public Object generate() {
        return new Object();
    }
}
