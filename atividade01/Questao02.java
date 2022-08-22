import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Questao02 {
    public static void main(String args[]) throws IOException {
        FileInputStream fis = new FileInputStream(args[0]);
        FileOutputStream fos = new FileOutputStream(args[1]);
        fis.transferTo(fos);
    }
}
