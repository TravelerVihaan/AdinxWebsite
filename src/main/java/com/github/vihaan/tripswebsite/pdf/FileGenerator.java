package com.github.vihaan.tripswebsite.pdf;

import com.itextpdf.text.DocumentException;

import java.io.IOException;

public interface FileGenerator<T> {

    T generate() throws IOException, DocumentException;
}
