import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TempFileExample {

    public static void main(String[] args) {

        try {
            new File("/myDirectory/myfile.txt");  // Compliant

            File.createTempFile("prefix", "suffix", new File("/mySecureDirectory"));  // Compliant

            if(SystemUtils.IS_OS_UNIX) {
              FileAttribute<Set<PosixFilePermission>> attr = PosixFilePermissions.asFileAttribute(PosixFilePermissions.fromString("rwx------"));
              Files.createTempFile("prefix", "suffix", attr); // Compliant
            }
            else {
              File f = Files.createTempFile("prefix", "suffix").toFile();  // Compliant
              f.setReadable(true, true);
              f.setWritable(true, true);
              f.setExecutable(true, true);
            }
        } catch (IOException e) {
            System.err.println("Failed to create temporary file: " + e.getMessage());
        }
    }
}
