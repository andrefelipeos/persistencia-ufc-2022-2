import java.util.Scanner;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;

public class Questao01 {
    public static void main(String parametros[]) throws IOException {
	String localDoArquivo = null;
	String token = null;
	Integer n1 = null;
	Integer n2 = null;

	/* Recebe os parâmetros do teclado. */

	Scanner entrada = new Scanner(System.in);

	System.out.print("Indique o caminho ou nome do arquivo: ");
	localDoArquivo = entrada.nextLine();

	System.out.print("Defina o inteiro 'n1' (ou deixe-o indefinido): ");
	token = entrada.nextLine();
	try {
	    n1 = Integer.valueOf(token);
	} catch (NumberFormatException nfe) {
	    n1 = 1;
	}

	System.out.print("Defina o inteiro 'n2' (ou deixe-o indefinido): ");
	token = entrada.nextLine();
	try {
	    n2 = Integer.valueOf(token);
	} catch (NumberFormatException nfe) {
	    n2 = null;
	}

	/* Abre, lê e mostra conteúdo do arquivo. */

	FileInputStream fis = new FileInputStream(localDoArquivo);
	Scanner arquivo = new Scanner(fis);
	int linhaAtual = 1;

	while (arquivo.hasNextLine()) {
	    String conteudoDaLinha = arquivo.nextLine();
	    if (linhaAtual >= n1 && (n2 == null || linhaAtual <= n2)) {
		System.out.println(conteudoDaLinha);
	    }
	    linhaAtual++;
	}
    }
}
