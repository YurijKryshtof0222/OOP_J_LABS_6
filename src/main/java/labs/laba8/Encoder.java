package labs.laba8;

import java.util.Arrays;

public class Encoder {
    private String keyword;

    public Encoder(String keyword) {
        this.keyword = keyword;
    }

    public String encode(String text) {
        StringBuilder result = new StringBuilder();

        // Проходимось по кожному символу в тексті та замінюємо його на символ з ключового слова
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            char keyChar = keyword.charAt(i % keyword.length());
            char encryptedChar = (char)(ch + keyChar);
            result.append(encryptedChar);
        }

        return result.toString();
    }

}