package Main;

public class Conversor {
    private final ApiService api = new ApiService();

    public void converter(int opcao, double valor) {
        String from = "", to = "";

        switch (opcao) {
            case 1: from = "BRL"; to = "USD"; break;
            case 2: from = "USD"; to = "BRL"; break;
            case 3: from = "EUR"; to = "USD"; break;
            case 4: from = "USD"; to = "EUR"; break;
            case 5: from = "GBP"; to = "JPY"; break;
            case 6: from = "JPY"; to = "GBP"; break;
            default:
                System.out.println("Opção inválida.");
                return;
        }

        Double taxa = api.obterTaxa(from, to);
        if (taxa != null) {
            double convertido = valor * taxa;
            System.out.printf("%.2f %s = %.2f %s\n", valor, from, convertido, to);
        } else {
            System.out.println("Erro ao obter taxa de conversão.");
        }
    }
}
