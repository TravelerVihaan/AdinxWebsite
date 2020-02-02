package com.github.vihaan.tripswebsite.pdf;

import java.io.IOException;

public interface FileGenerator<T> {

    T generate() throws IOException;
}
