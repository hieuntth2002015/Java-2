package Lab10.vd2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerFromFileWithCatch {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(new File("test.in"));
        }catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
