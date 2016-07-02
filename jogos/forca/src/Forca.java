import java.util.Scanner;

public class Forca {

	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		System.out.println("Bem Vindo ao Jogo da Forca 1.0");
		System.out.println("Informa a palavra:");
		char[] palavra = leitor.next().toCharArray();
		char[] completada = new char[palavra.length];
		for (int i = 0, j = palavra.length; i < j; i++) {
			completada[i] = '_';
		}
		Integer limite = 7;
		Integer erros = 0;
		Integer acertos = 0;
		while (true) {
			if (erros >= limite || acertos >= palavra.length) {
				break;
			}
			System.out.println("Informe a letra");
			char letra = leitor.next().toCharArray()[0];
			boolean achou = false;
			for (int i = 0, j = palavra.length; i < j; i++) {
				if (palavra[i] == letra) {
					acertos++;
					completada[i] = letra;
					achou = true;
				}
			}
			if (achou) {
				System.out.println(completada);
			} else {
				erros++;
			}
		}
		if (erros >= limite) {
			System.err.println("Você perdeu");
			System.err.println("A palavra era \"" + new String(palavra) + "\"");
		} else {
			System.err.println("Parabéns!");
		}
		leitor.close();
	}
}
