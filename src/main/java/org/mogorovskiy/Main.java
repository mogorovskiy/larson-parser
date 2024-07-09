package org.mogorovskiy;

import org.mogorovskiy.parser.AttorneyParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class Main {

    @Autowired
    private AttorneyParser attorneyParser = new AttorneyParser();

    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        attorneyParser.parse();
    }
}
