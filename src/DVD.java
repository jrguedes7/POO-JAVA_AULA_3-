import java.util.InputMismatchException;
import java.util.Scanner;

public class DVD extends Midia {

    private int numeroFaixas;

    // Construtor sem parâmetros.
    public DVD() {
        this(0, 0.0, "Nenhum", 0); // Chamada ao construtor com parâmetros
    }

    // Construtor com parâmetros.
    public DVD(int codigo, double preco, String nome, int numeroFaixas) {
        super(codigo, preco, nome); // Chamada ao construtor da classe Midia
        setNumeroFaixas(numeroFaixas);
    }

    // Função para impressão do tipo.
    public String getTipo() {
        return "DVD: ";
    }

    // Função que retorna o conteúdo dos campos desta
    // classe e da classe Midia (usando super!).
    public String getDetalhes() {
        return super.getDetalhes() + "\n" +
                "Número de faixas: " + numeroFaixas + "\n";
    }

    public void setNumeroFaixas(int numeroFaixas) {
        if (numeroFaixas > 0) {
            this.numeroFaixas = numeroFaixas;
        } else {
            System.err.println("Erro: Número de faixas inválido. Deve ser maior que zero.");
        }
    }

    // Função para leitura dos dados via teclado dos
    // campos desta classe e dos campos da classe
    // Midia (usando super!).
    public void inserirDados() {
        // Leitura dos dados contidos nos campos
        // pertencentes a classe Midia.
        super.inserirDados();

        Scanner in = new Scanner(System.in);

        // Leitura dos dados do teclado.
        System.out.printf("\n Entre com o número de faixas: ");
        try {
            int numeroFaixasLido = in.nextInt();
            setNumeroFaixas(numeroFaixasLido);
        } catch (InputMismatchException e) {
            System.err.println("Erro: Tipo de dado inválido para número de faixas.");
            in.next(); // Consumir entrada incorreta
        }
    }

    @Override
    public String toString() {
        return getTipo() + super.toString() + "\nNúmero de faixas: " + numeroFaixas;
    }
}
