package ru.job4j.lsp.example1;

/**
 * Нарушение LSP по причине нарушения контракта постусловия
 * (при передаче Null вместо строки должно выбрасываться исключение - в данном методе возвращается пустая строка)
 */
public class UpperStringFormatter extends StringFormatter {
    @Override
    public String formatString(String string) {
        if (string == null) {
            return "";
        }
        return string.toUpperCase().replace(" ", "");
    }
}
