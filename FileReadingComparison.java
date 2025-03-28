import java.io.*;

public class FileReadingComparison {
    public static void main(String[] args) {
        String filePath = "SampleFile";

        System.out.println("File Size | FileReader Time (ms) | InputStreamReader Time (ms)");
        System.out.println("------------------------------------------------------------");

        long fileReaderTime = measureFileReader(filePath);
        long inputStreamReaderTime = measureInputStreamReader(filePath);

        System.out.printf("%8s | %20d | %28d%n", "500MB", fileReaderTime, inputStreamReaderTime);
    }

    // FileReader (Character Stream)
    private static long measureFileReader(String filePath) {
        long startTime = System.nanoTime();
        try (FileReader fr = new FileReader(filePath)) {
            while (fr.read() != -1) {}
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (System.nanoTime() - startTime) / 1_000_000;
    }


    private static long measureInputStreamReader(String filePath) {
        long startTime = System.nanoTime();
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath))) {
            while (isr.read() != -1) {}
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (System.nanoTime() - startTime) / 1_000_000;
    }
}
