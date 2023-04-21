package labs.laba9;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Arrays;
import java.util.Random;
import java.util.Vector;

public class Main {
    private static final int N = 5;
    private static final int M = 4;
    private static final int A = 0;
    private static final int B = 8;

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        byte[][] matrix = generateRandomlyFilledMatrix(M, N, A, B);
        Vector<InputStream> streamVector = generateStreamVector(matrix, M);
        try (InputStream is = new SequenceInputStream(streamVector.elements())) {
            System.out.println("Sequence stream :");
            printStream(is);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            streamVector.forEach(Main::closeStream);
        }
    }

    private static byte[][] generateRandomlyFilledMatrix(int rows, int cols, int min, int max) {
        byte[][] matrix = new byte[rows][cols];

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                matrix[i][j] = (byte)RANDOM.nextInt(min, max + 1);

        return matrix;
    }

    private static Vector<InputStream> generateStreamVector(byte[][] matrix, int rows) {
        Vector<InputStream> streamVector = new Vector<>();

        for (int i = 0; i < rows; i++)
            streamVector.add(new ByteArrayInputStream(matrix[i]));

        return streamVector;
    }

    private static void printStream(InputStream inputStream) {
        try {
            System.out.println(Arrays.toString(inputStream.readAllBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void closeStream(InputStream inputStream) {
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}