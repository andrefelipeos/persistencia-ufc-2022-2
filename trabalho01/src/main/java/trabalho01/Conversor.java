/*
 * 3. Crie uma classe Java que recebe via linha de comando o nome de um arquivo
 * qualquer em formato JSON e o converte para os formatos CSV e XML.
 * */

package trabalho01;

public class Conversor {

	public static void main(String[] args) {
		String localDoArquivo;

		if (args.length == 0) {
			System.out.println("Passe o caminho para um arquivo como parâmentro!");
			return;
		} else {
			localDoArquivo = args[0];
		}
	}

}
