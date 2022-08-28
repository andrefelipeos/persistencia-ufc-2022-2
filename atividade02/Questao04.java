/*
4. Escreva um arquivo de propriedades Java via editor de textos. Esse arquivo deve ter os dados de chave e valor. Exemplo:

    arquivo config.properties
        arquivo = meu_arquivo.txt
        linha_inicial = 1
        linha_final = 3
    Depois, escreva uma classe Java que exibe da linha_inicial até a linha_final do arquivo, conforme definidos no arquivo de propriedades config.properties.
*/
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class Questao01 {
    public static void main(String args[]) throws IOException {
        Properties parametros = new Properties();
        parametros.load(new FileInputStream("config.properties"));

        String localDoArquivo = parametros.getProperty("arquivo");
        int linha_inicial = Integer.parseInt(parametros.getProperty("linha_inicial"));
        int linha_final = Integer.parseInt(parametros.getProperty("linha_final"));

	/* Abre, lê e mostra conteúdo do arquivo. */

	InputStream is = new FileInputStream(localDoArquivo);
	Scanner arquivo = new Scanner(is);

	int linhaAtual = 1;
	while (arquivo.hasNextLine()) {
	    String conteudoDaLinha = arquivo.nextLine();
	    if (linhaAtual >= linha_inicial && linhaAtual <= linha_final) {
		System.out.println(conteudoDaLinha);
	    }
	    linhaAtual++;
	}

	arquivo.close();
    }
}
