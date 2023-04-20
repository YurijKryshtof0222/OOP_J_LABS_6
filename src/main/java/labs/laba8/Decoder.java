package labs.laba8;

import java.util.Arrays;

public class Decoder {
    private String keyword;

    public Decoder(String keyword) {
        this.keyword = keyword;

    }

    public String decode(String text) {
        StringBuilder result = new StringBuilder();

        // Проходимось по кожному символу в зашифрованому тексті та замінюємо його на вихідний символ
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            char keyChar = keyword.charAt(i % keyword.length());
            char decryptedChar = (char)(c - keyChar);
            result.append(decryptedChar);
        }
        return result.toString();
    }

}