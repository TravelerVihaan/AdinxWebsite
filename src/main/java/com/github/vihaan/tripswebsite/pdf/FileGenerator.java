package com.github.vihaan.tripswebsite.pdf;

import com.itextpdf.text.DocumentException;

import java.io.IOException;

public interface FileGenerator<T> {

    void generate() throws IOException, DocumentException;
}
