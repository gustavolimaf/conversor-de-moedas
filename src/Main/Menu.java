package Main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static void exibir() {
        Scanner scanner = new Scanner(System.in);
        Conversor conversor = new Conversor();

        while (true) {
            System.out.println("\n=== Conversor de Moedas ===");
            System.out.println("1. BRL -> USD");
            System.out.println("2. USD -> BRL");
            System.out.println("3. EUR -> USD");
            System.out.println("4. USD -> EUR");
            System.out.println("5. GBP -> JPY");
            System.out.println("6. JPY -> GBP");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao;
            try {
                opcao = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número entre 1 e 7.");
                scanner.nextLine(); 
                continue;
            }

            if (opcao == 7) {
                System.out.println("Programa encerrado. Até logo!");
                break;
            }

            System.out.print("Informe o valor: ");
            double valor;
            try {
                valor = scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido. Digite um número válido.");
                scanner.nextLine();
                continue;
            }

            conversor.converter(opcao, valor);
        }

        scanner.close();
    }
}
