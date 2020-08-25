package src;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerReadFile {
    public static void main(String[] args) throws FileNotFoundException {
        // Create an instance of File for data.txt file.
        File file = new File("familyUnits.txt");
       
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
    }
}
