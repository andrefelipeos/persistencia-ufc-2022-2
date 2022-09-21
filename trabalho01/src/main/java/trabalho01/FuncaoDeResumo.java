package trabalho01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import jakarta.xml.bind.DatatypeConverter;

public class FuncaoDeResumo {

	public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
		String localDoArquivo;

		if (args.length == 0) {
			System.out.println("Passe o caminho para um arquivo como parâmentro!");
			return;
		} else {
			localDoArquivo = args[0];
		}

		MessageDigest funcaoDeResumo = MessageDigest.getInstance("SHA-1");

		funcaoDeResumo.update(Files.readAllBytes(Paths.get(localDoArquivo)));
		byte[] resumoEmBytes = funcaoDeResumo.digest();

		String resumo = DatatypeConverter.printHexBinary(resumoEmBytes);
		System.out.println(resumo.toUpperCase());
	}

}
