package atividade03;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class Desserializa {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		InputStream is = new FileInputStream("arquivo.txt");
		ObjectInputStream ois = new ObjectInputStream(is);
		while (true) {
			try {
				System.out.println(((Filme) ois.readObject()));
			} catch (EOFException exception) {
				break;
			}
		}
		ois.close();
	}

}
