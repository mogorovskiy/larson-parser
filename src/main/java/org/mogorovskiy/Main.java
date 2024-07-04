package org.mogorovskiy;

import org.mogorovskiy.parser.AttorneyParser;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        new AttorneyParser().parse();
    }
}