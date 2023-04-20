package labs.laba8;

import java.io.*;
import java.util.Base64;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        final String keyword = "Криштоф Юрій Тарасович";
        String textToEncode = """
                В склад програмного забезпечення комп'ютерів входять як універcальні
                засоби (системне програмне забезпечення), так і прикладні програми,
                орієнтовані на окремі проблемні галузі застосування(прикладне програмне забезпечення)
                """;
        String encodedText = new Encoder(keyword).encode(textToEncode);
        String decodedText = new Decoder(keyword).decode(encodedText);

        System.out.println("Encoded text: " + encodedText);
        System.out.println();
        System.out.println("Decoded text:" + decodedText);
        System.out.println();


        String encodedFilePath = "src/main/java/labs/laba8/resources/Encoded";
        String decodedFilePath = "src/main/java/labs/laba8/resources/Decoded";

        FileWriter encodedWriter = new FileWriter(encodedFilePath);
        FileWriter decodedWriter = new FileWriter(decodedFilePath);
        encodedWriter.write(encodedText);
        decodedWriter.write(decodedText);
        encodedWriter.close();
        decodedWriter.close();

        Scanner encodedFileSc = new Scanner(new File(encodedFilePath));
        Scanner decodedFileSc = new Scanner(new File(decodedFilePath));
        System.out.println("Reading the content of \"Encoded\" file");
        while (encodedFileSc.hasNext()) {
            System.out.println(encodedFileSc.nextLine());
        }
        System.out.println();
        System.out.println("Reading the content of \"Decoded\" file:");
        while (decodedFileSc.hasNext()) {
            System.out.println(decodedFileSc.nextLine());
        }
        encodedFileSc.close();
        decodedFileSc.close();
    }

}
