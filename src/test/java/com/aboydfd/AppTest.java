package com.aboydfd;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test void appHasAGreeting() throws IOException {
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));
        App.main(null);
        bo.flush();
        String allWrittenLines = new String(bo.toByteArray());
        assertNotEquals("", allWrittenLines);
    }
}
