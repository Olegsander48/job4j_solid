package ru.job4j.lsp.example1;

public class StringFormatter {
    public String formatString(String string) {
        if (string == null) {
            throw new IllegalArgumentException("String cannot be null");
        }
        return string.toLowerCase().replace(" ", "");
    }
}
