package org.mogorovskiy.util;

public class TextTrimmer {

    public static String trimText(String text, int sentenceCount) {
        if (text == null || text.isEmpty()) {
            return text;
        }

        String[] sentences = text.split("\\.\\s*");
        StringBuilder trimmedText = new StringBuilder();

        for (int i = 0; i < Math.min(sentenceCount, sentences.length); i++) {
            String sentenceToAdd = sentences[i] + ". ";
            if (trimmedText.length() + sentenceToAdd.length() <= 255) {
                trimmedText.append(sentenceToAdd);
            } else {
                break;
            }
        }

        return trimmedText.toString().trim();
    }
}
