/*
1. Crie uma aplicação Java para receber via argumento de linha de comando um nome de arquivo texto e uma string S. A aplicação deve exibir todas as linhas que tenham S como substring, independente dos caracteres estarem em caixa alta ou baixa (case-insensitive).
*/
import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.util.Scanner;

public class Questao01 {
    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream(args[0]);
        Scanner arquivo = new Scanner(is);

        while (arquivo.hasNextLine()) {
            String linha = arquivo.nextLine();
            if (linha.toLowerCase().contains(args[1].toLowerCase())) {
                System.out.println(linha);
            }
        }

        arquivo.close();
    }
}
