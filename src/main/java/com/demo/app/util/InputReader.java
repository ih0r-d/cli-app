package com.demo.app.util;

import org.jline.reader.LineReader;

public class InputReader {
    private static final Character DEFAULT_MASK = '*';

    private Character mask;
    private LineReader lineReader;

    public InputReader(LineReader lineReader) {
        this(lineReader, null);
    }

    public InputReader(LineReader lineReader, Character mask) {
        this.lineReader = lineReader;
        this.mask = mask != null ? mask : DEFAULT_MASK;
    }

    public String prompt(String prompt) {
        return prompt(prompt, null, true);
    }

    public String prompt(String prompt, String defaultValue) {
        return prompt(prompt, defaultValue, true);
    }

    public String prompt(String prompt, String defaultValue, boolean echo) {
        String answer = echo ? lineReader.readLine(prompt + ": ") : lineReader.readLine(prompt + ": ", mask);
        return answer.isEmpty() ? defaultValue : answer;
    }
}

