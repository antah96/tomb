import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TempFileExample {

    public static void main(String[] args) {

        try {
            File temp = File.createTempFile("temp", ".txt");
            temp.deleteOnExit();

            BufferedWriter out = new BufferedWriter(new FileWriter(temp));
            out.write("aString");
            out.close();

            System.out.println("Temporary file created with insecure permissions. Now an attacker can perform malicious actions using the file.");
        } catch (IOException e) {
            System.err.println("Failed to create temporary file: " + e.getMessage());
        }
    }
}
