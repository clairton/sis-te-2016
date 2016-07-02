import java.util.Random;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		String CampoChave[][] = new String[10][10];
		String Campo[][] = new String[10][10];
		Scanner leitor = new Scanner(System.in);

		for (int i = 0; i < Campo.length; i++) {
			for (int j = 0; j < Campo.length; j++) {
				if (new Random().nextInt(10) == 3) {
					Campo[i][j] = "O";
				} else {
					Campo[i][j] = "X";
				}
				CampoChave[i][j] = "X";
			}
		}
		Campo[9][9] = "O";
		String teste = "";
		for (int cont = 0; cont < 5; cont++) {
			for (int t = 0; t < CampoChave.length; t++) {
				teste = "";
				for (int j = 0; j < CampoChave.length; j++) {
					teste = teste + CampoChave[t][j];
				}
				System.out.println(teste);
			}
			System.out.println("");
			System.out.println("");
			System.out.println("Informe posição inicial");
			Integer informa1 = leitor.nextInt();
			System.out.println("Informe posição Final");
			Integer informa2 = leitor.nextInt();
			if (Campo[informa1][informa2] == "O") {
				System.out.println("Ganhou");
				break;
			} else {
				System.out.println("Errou");
			}
		}
		System.out.println("Fim de jogo");
	}

}
