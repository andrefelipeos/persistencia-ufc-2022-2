import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Questao02 {
    public static void main(String args[]) throws IOException {
        FileInputStream fis1 = new FileInputStream(args[0]);
        FileInputStream fis2 = new FileInputStream(args[1]);
        FileOutputStream fos = new FileOutputStream(args[2]);

        fis1.transferTo(fos);
        fis2.transferTo(fos);

        fis1.close();
        fis2.close();
        fos.close();
    }
}
