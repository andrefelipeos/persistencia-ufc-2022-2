/*
 * 4. Crie uma classe Java que recebe como entrada de teclado o nome de um
 * arquivo qualquer e o compacta para o formato ZIP ou outro formato de
 * compressão à sua escolha.
 * */

package trabalho01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Compactador {

	public static void main(String[] args) throws IOException {
		String localDoArquivo;

		Scanner teclado = new Scanner(System.in);
		System.out.print("Caminho do arquivo a ser compactado:  ");
		localDoArquivo = teclado.nextLine();

		File arquivo = new File(localDoArquivo);
		ZipEntry arquivoParaCompactar = new ZipEntry(arquivo.getName());

		FileOutputStream fos = new FileOutputStream(arquivo.getPath() + ".zip");
		ZipOutputStream compactador = new ZipOutputStream(fos);

		compactador.putNextEntry(arquivoParaCompactar);

		FileInputStream fis = new FileInputStream(arquivo);
		byte[] arrayDeBytesAuxiliar = new byte[1024];
		int quantidadeDeBytesLidos;
		while ((quantidadeDeBytesLidos = fis.read(arrayDeBytesAuxiliar)) >= 0) {
			compactador.write(arrayDeBytesAuxiliar, 0, quantidadeDeBytesLidos);
		}

		fis.close();
		compactador.close();
		teclado.close();
	}

}
